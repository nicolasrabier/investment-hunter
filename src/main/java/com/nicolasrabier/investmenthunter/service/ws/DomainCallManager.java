package com.nicolasrabier.investmenthunter.service.ws;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicolasrabier.investmenthunter.persistence.model.Configuration;
import com.nicolasrabier.investmenthunter.persistence.model.WebServiceCall;
import com.nicolasrabier.investmenthunter.persistence.repository.ConfigurationRepository;
import com.nicolasrabier.investmenthunter.persistence.repository.WebServiceCallRepository;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.DomainSearchContractsV2SearchResult;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.DomainSearchWebApiV2ModelsSearchParameters;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Token;

@Component
public class DomainCallManager implements WsCallManager {

	Logger logger = LoggerFactory.getLogger(DomainCallManager.class);

	@Value("${domain.api.protocol}")
	String protocol;

	@Value("${domain.api.host}")
	String host;

	@Value("${domain.api.port}")
	int port;

	@Value("${domain.oauth.client.id}")
	String domainOauthClientId;

	@Value("${domain.oauth.client.secret}")
	String domainOauthClientSecret;

	@Value("${domain.api.token.url}")
	String tokenUrl;

	@Value("${domain.api.listings.residential.search.url}")
	String listingsResidentialSearchUrl;

	public DomainCallManager() {
	}

	/**
	 * 
	 * @return
	 */
	private Token getToken() {
		Token token = null;
		// verify in database that we have a token

		Configuration config = configRepo.findById(1);
		if (config != null && config.getDomainToken() != null
				&& !"".equals(config.getDomainToken().trim())) {
			
			token = new Token(config.getDomainToken(), config.getDomainTokenExpiryIn(), null, null);
			
		} else {
			token = getNewToken();
		}
		
		return token;
	}

	private Token getNewToken() {
		WebServiceCall wsCall = null;
		try {
			HttpHeaders headers = createHeaders(domainOauthClientId, domainOauthClientSecret);

			// Create the request body as a MultiValueMap
			MultiValueMap<String, String> tokenBody = new LinkedMultiValueMap<String, String>();

			tokenBody.add("grant_type", "client_credentials");
			tokenBody.add("scope", "api_agencies_read api_listings_read");

			HttpEntity<Object> tokenRequest = new HttpEntity<Object>(tokenBody, headers);

			URIBuilder uriBuilder = new URIBuilder();
			uriBuilder.setScheme(protocol).setHost(host).setPath(tokenUrl);
			URI uri = uriBuilder.build();

			wsCall = saveWebServiceCall(uri, tokenRequest);
			
			//TODO: add throttling to ws call cannot exceed 1000 requests per minute
			
			ResponseEntity<Token> tokenResponse = restTemplate.exchange(uri, HttpMethod.POST, tokenRequest,
					Token.class);

			wsCall.setStatusCode(tokenResponse.getStatusCodeValue());
			wsCall.setResponseEntity((new ObjectMapper()).writeValueAsString(tokenResponse));
			wsCallRepo.save(wsCall);
			
			Token token = tokenResponse.getBody();
			
			Configuration config = configRepo.findById(1);
			if(config == null) {
				config = new Configuration();
				config.setId(1);
			}
			config.setDomainToken(token.getAccessToken());
			config.setDomainTokenExpiryIn(token.getExpiresIn());
			configRepo.save(config);
			
			return token;
		} catch (HttpClientErrorException e) {
			logger.error(new StringBuilder(e.getRawStatusCode()).append(" - ").append(e.getMessage()).toString());
			wsCall.setStatusCode(e.getRawStatusCode());
			wsCall.setResponseEntity(e.getResponseBodyAsString());
			wsCallRepo.save(wsCall);
			
		} catch (Exception e) {
			logger.error(new StringBuilder("Can't obtain token: ").append(e.getMessage()).toString());
		}
		return new Token();
	}

	private HttpHeaders createHeaders(String clientId, String clientSecret) {
		return new HttpHeaders() {
			private static final long serialVersionUID = -5862419048793952223L;

			{
				String auth = clientId + ":" + clientSecret;
				String authHeader = "Basic "
						+ new String(Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII"))));
				set("Authorization", authHeader);
			}
		};
	}

	public List<DomainSearchContractsV2SearchResult> getListing(
			DomainSearchWebApiV2ModelsSearchParameters searchParams) {
		WebServiceCall wsCall = null;
		try {
			Token token = getToken();

			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", "Bearer " + token.getAccessToken());

			URIBuilder uriBuilder = new URIBuilder();
			uriBuilder.setScheme(protocol).setHost("api.domain.com.au").setPath(listingsResidentialSearchUrl);
			URI uri = uriBuilder.build();
			// System.out.println(uri.toString());

			HttpEntity<Object> listingRequest = new HttpEntity<Object>(searchParams, headers);

			wsCall = saveWebServiceCall(uri, listingRequest);
			
			ResponseEntity<List<DomainSearchContractsV2SearchResult>> listingResponse = restTemplate.exchange(uri,
					HttpMethod.POST, listingRequest,
					new ParameterizedTypeReference<List<DomainSearchContractsV2SearchResult>>() {
					});

			wsCall.setStatusCode(listingResponse.getStatusCodeValue());
			wsCall.setResponseEntity((new ObjectMapper()).writeValueAsString(listingResponse));
			wsCallRepo.save(wsCall);
			
			return listingResponse.getBody();
		
	    // catch issue when token has expired
		} catch (HttpClientErrorException e) {
			logger.error(new StringBuilder(e.getRawStatusCode()).append(" - ").append(e.getMessage()).toString());
			wsCall.setStatusCode(e.getRawStatusCode());
			wsCall.setResponseEntity(e.getResponseBodyAsString());
			wsCallRepo.save(wsCall);
			switch (e.getRawStatusCode()) {
			case 401:
				getNewToken();
				return getListing(searchParams);

			case 403:
				logger.error(e.getMessage());

			case 429:
				try {
					TimeUnit.SECONDS.sleep(10);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				return getListing(searchParams);
			}
		} catch (Exception e) {
			logger.error(new StringBuilder("Can't get list of properties: ").append(e.getMessage()).toString());
		}
		return new ArrayList<DomainSearchContractsV2SearchResult>();
	}

	/**
	 * Save web service call
	 * @param uri
	 * @param httpEntity
	 * @return
	 * @throws JsonProcessingException
	 */
	private WebServiceCall saveWebServiceCall(URI uri, HttpEntity<Object> httpEntity) throws JsonProcessingException {
		// save the web service call
		String httpEntityJson = (new ObjectMapper()).writeValueAsString(httpEntity);
		WebServiceCall wsCall = new WebServiceCall(uri.toString(), HttpMethod.POST.name(), httpEntityJson);
		return wsCallRepo.save(wsCall);
	}
}
