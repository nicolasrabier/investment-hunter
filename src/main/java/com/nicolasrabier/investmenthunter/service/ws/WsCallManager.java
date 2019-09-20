package com.nicolasrabier.investmenthunter.service.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.nicolasrabier.investmenthunter.persistence.repository.ConfigurationRepository;
import com.nicolasrabier.investmenthunter.persistence.repository.WebServiceCallRepository;

public interface WsCallManager {

	@Autowired RestTemplate restTemplate = null;

	@Autowired
	ConfigurationRepository configRepo = null;;
	
	@Autowired
	WebServiceCallRepository wsCallRepo = null;

}
