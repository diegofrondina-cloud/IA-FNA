package com.uncledavecode.ai_rag.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.uncledavecode.fna.dao")
@EnableTransactionManagement
public class JpaConfig {
}
