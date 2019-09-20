package com.nicolasrabier.investmenthunter.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.nicolasrabier.investmenthunter.persistence.repository")
@EntityScan("com.nicolasrabier.investmenthunter.persistence.model")
@EnableJpaAuditing
public class PersistenceConfig {

}
