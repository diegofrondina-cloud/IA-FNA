package com.uncledavecode.ai_rag.service;

import com.uncledavecode.fna.dao.FnaProductDAO;
import com.uncledavecode.fna.dto.FnaProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class FnaDataService {
    @Autowired
    private final FnaProductDAO fnaProductDAO;
    private static final Logger log = LoggerFactory.getLogger(FnaDataService.class);
    @Autowired
    public FnaDataService(FnaProductDAO fnaProductDAO) {
        this.fnaProductDAO = fnaProductDAO;
    }
    
    public List<Document> loadFnaProductsAsDocuments() {
        List<Document> documents = new ArrayList<>();
        
        try {
            // ID hardcodeado para testing - cambiar después
            Long testProductId = 1L;
            
            FnaProductDTO product = fnaProductDAO.findByProductId(testProductId);
            if (product != null) {
                documents.addAll(createGranularProductDocuments(product));
                log.info("Producto FNA cargado exitosamente: ID={}, Nombre={}",
                  product.getId(), product.getPodDisplayName());
            } else {
                log.warn("No se encontró producto con ID: {}", testProductId);
            }
            
        } catch (Exception e) {
           log.error("Error cargando productos de FNA: ", e);
        }
        
        return documents;
    }
    
    private List<Document> createGranularProductDocuments(FnaProductDTO product) {
        List<Document> documents = new ArrayList<>();
        
        // Documento principal del producto
        documents.add(createMainProductDocument(product));
        
        // Documentos granulares por campos específicos
        documents.add(createFieldDocument(product, "status", product.getStatus(), "Estado del producto FNA"));
        documents.add(createFieldDocument(product, "podDisplayName", product.getPodDisplayName(), "Nombre del producto"));
        documents.add(createFieldDocument(product, "bookingType", product.getBookingType(), "Tipo de booking"));
        documents.add(createFieldDocument(product, "processStep", product.getProcessStep(), "Paso del proceso"));
        documents.add(createFieldDocument(product, "finalDecision", product.getFinalDecision(), "Decisión final"));
        documents.add(createFieldDocument(product, "isActive", product.getIsActive().toString(), "Estado activo"));
        
        return documents;
    }
    
    private Document createMainProductDocument(FnaProductDTO product) {
        String content = String.format(
            "Producto FNA con ID %d: Este es un producto financiero con nombre '%s', " +
            "tipo de booking '%s', estado '%s', y paso del proceso '%s'. " +
            "La decisión final es '%s' y está %s.",
            product.getId(),
            product.getPodDisplayName(),
            product.getBookingType(),
            product.getStatus(),
            product.getProcessStep(),
            product.getFinalDecision(),
            product.getIsActive() ? "activo" : "inactivo"
        );
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("id", product.getId().toString());
        metadata.put("fnaId", product.getFnaId().toString());
        metadata.put("pofId", product.getPofId().toString());
        metadata.put("type", "fna_product_main");
        metadata.put("podDisplayName", product.getPodDisplayName());
        metadata.put("bookingType", product.getBookingType());
        metadata.put("status", product.getStatus());
        
        return new Document(content, metadata);
    }
    
    private Document createFieldDocument(FnaProductDTO product, String fieldName, String fieldValue, String description) {
        String content = String.format(
            "El %s del producto FNA '%s' (ID: %d) es: %s",
            description,
            product.getPodDisplayName(),
            product.getId(),
            fieldValue
        );
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("id", product.getId().toString());
        metadata.put("fnaId", product.getFnaId().toString());
        metadata.put("fieldName", fieldName);
        metadata.put("fieldValue", fieldValue);
        metadata.put("podDisplayName", product.getPodDisplayName());
        metadata.put("type", "fna_product_field");
        
        return new Document(content, metadata);
    }
}