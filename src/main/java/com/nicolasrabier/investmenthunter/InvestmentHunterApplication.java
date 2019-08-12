package com.nicolasrabier.investmenthunter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories("com.nicolasrabier.investmenthunter.persistence.repository")
@EntityScan("com.nicolasrabier.investmenthunter.persistence.model")
@SpringBootApplication
public class InvestmentHunterApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentHunterApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
