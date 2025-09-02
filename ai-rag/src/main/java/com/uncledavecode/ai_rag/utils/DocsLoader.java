package com.uncledavecode.ai_rag.utils;

import com.uncledavecode.ai_rag.fna.service.FnaDataService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DocsLoader {

    private final JdbcClient jdbcClient;
    private final VectorStore vectorStore;
    private final FnaDataService fnaDataService;

    @Autowired
    public DocsLoader(JdbcClient jdbcClient, VectorStore vectorStore, FnaDataService fnaDataService) {
        this.jdbcClient = jdbcClient;
        this.vectorStore = vectorStore;
        this.fnaDataService = fnaDataService;
    }

    @PostConstruct
    public void loadDocs(){
        var count = jdbcClient.sql("select count(*) from vector_store")
                .query(Integer.class)
                .single();

        if(count == 0){
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