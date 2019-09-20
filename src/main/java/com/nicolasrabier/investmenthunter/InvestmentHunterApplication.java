package com.nicolasrabier.investmenthunter;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class InvestmentHunterApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(InvestmentHunterApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@PostConstruct
    public void afterInitialize() {
		Logger logger = LoggerFactory.getLogger(InvestmentHunterApplication.class);
		logger.info("\n" + 
				"_________ _                 _______  _______ _________ _______  _______  _       _________                   _       _________ _______  _______ \n" + 
				"\\__   __/( (    /||\\     /|(  ____ \\(  ____ \\\\__   __/(       )(  ____ \\( (    /|\\__   __/|\\     /||\\     /|( (    /|\\__   __/(  ____ \\(  ____ )\n" + 
				"   ) (   |  \\  ( || )   ( || (    \\/| (    \\/   ) (   | () () || (    \\/|  \\  ( |   ) (   | )   ( || )   ( ||  \\  ( |   ) (   | (    \\/| (    )|\n" + 
				"   | |   |   \\ | || |   | || (__    | (_____    | |   | || || || (__    |   \\ | |   | |   | (___) || |   | ||   \\ | |   | |   | (__    | (____)|\n" + 
				"   | |   | (\\ \\) |( (   ) )|  __)   (_____  )   | |   | |(_)| ||  __)   | (\\ \\) |   | |   |  ___  || |   | || (\\ \\) |   | |   |  __)   |     __)\n" + 
				"   | |   | | \\   | \\ \\_/ / | (            ) |   | |   | |   | || (      | | \\   |   | |   | (   ) || |   | || | \\   |   | |   | (      | (\\ (   \n" + 
				"___) (___| )  \\  |  \\   /  | (____/\\/\\____) |   | |   | )   ( || (____/\\| )  \\  |   | |   | )   ( || (___) || )  \\  |   | |   | (____/\\| ) \\ \\__\n" + 
				"\\_______/|/    )_)   \\_/   (_______/\\_______)   )_(   |/     \\|(_______/|/    )_)   )_(   |/     \\|(_______)|/    )_)   )_(   (_______/|/   \\__/\n" + 
				"                                                                                                                                                \n" + 
				"\n");

	}
}
