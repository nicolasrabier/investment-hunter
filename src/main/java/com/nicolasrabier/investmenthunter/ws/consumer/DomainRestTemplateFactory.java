package com.nicolasrabier.investmenthunter.ws.consumer;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

public class DomainRestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {

	private RestTemplate restTemplate;
	
	@Value("${domain.api.host}")
	String host;
	@Value("${domain.api.port}")
	int port;
	@Value("${domain.api.protocol}")
	String protocol;
	

	public RestTemplate getObject() {
		return restTemplate;
	}

	public Class<RestTemplate> getObjectType() {
		return RestTemplate.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void afterPropertiesSet() {
		HttpHost httpHost = new HttpHost(host, port, protocol);
		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactoryBasicAuth(httpHost));
	}
}
