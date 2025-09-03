package com.drondina.ai_rag.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

@Configuration
public class PostgresDataSourceConfig {

    @Bean(name = "pgvectorDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.ai.vectorstore.pgvector")
    public DataSource pgvectorDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pgvectorJdbcTemplate")
    @Primary
    public JdbcTemplate pgvectorJdbcTemplate(DataSource pgvectorDataSource) {
        return new JdbcTemplate(pgvectorDataSource);
    }
}
