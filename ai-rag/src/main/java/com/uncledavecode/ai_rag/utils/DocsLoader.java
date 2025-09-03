package com.uncledavecode.ai_rag.utils;

import com.uncledavecode.ai_rag.fna.service.FnaDataService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DocsLoader {

    private final JdbcTemplate jdbcTemplate;
    private final VectorStore vectorStore;
    private final FnaDataService fnaDataService;

    @Autowired
    public DocsLoader(@Qualifier("pgvectorJdbcTemplate") JdbcTemplate jdbcTemplate,
                      VectorStore vectorStore,
                      FnaDataService fnaDataService) {
        this.jdbcTemplate = jdbcTemplate;
        this.vectorStore = vectorStore;
        this.fnaDataService = fnaDataService;
    }

    @PostConstruct
    public void loadDocs() {
        Integer count = jdbcTemplate.queryForObject("SELECT count(*) FROM vector_store", Integer.class);

        if (count == null || count == 0) {
            log.info("Loading FNA products into vector store");

            List<Document> fnaDocuments = fnaDataService.loadFnaProductsAsDocuments();

            if (!fnaDocuments.isEmpty()) {
                vectorStore.accept(fnaDocuments);
                log.info("Loaded {} FNA documents into vector store", fnaDocuments.size());
            } else {
                log.warn("No FNA documents were loaded into vector store");
            }
        } else {
            log.info("Vector store already contains {} documents, skipping load", count);
        }
    }
}
