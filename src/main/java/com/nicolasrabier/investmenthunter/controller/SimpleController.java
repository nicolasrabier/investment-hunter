package com.nicolasrabier.investmenthunter.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.DomainSearchContractsV2SearchResult;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.DomainSearchWebApiV2ModelsSearchParameters;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Location;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Token;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.type.ListingType;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.type.State;


@Controller
public class SimpleController {
	@Value("${spring.application.name}")
	String appName;
	@Value("${domain.oauth.client.id}")
	String domainOauthClientId;
	@Value("${domain.oauth.client.secret}")
	String domainOauthClientSecret;
	@Value("${domain.api.protocol}")
	String protocol;
	@Value("${domain.api.host}")
	String host;
	@Value("${domain.api.port}")
	int port;
	@Value("${domain.api.token.url}")
	String tokenUrl;
	@Value("${domain.api.listings.residential.search.url}")
	String listingsResidentialSearchUrl;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	public String homePage(Model model) throws URISyntaxException {
		model.addAttribute("appName", appName);
		model.addAttribute("domainOauthClientId", domainOauthClientId);
		model.addAttribute("domainOauthClientSecret", domainOauthClientSecret);

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
				System.out.println(uri.toString());
			
			ResponseEntity<Token> tokenResponse = restTemplate.exchange(uri, HttpMethod.POST, tokenRequest, Token.class);
			System.out.println(tokenResponse);
			
			headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.add("Authorization", "Bearer " + tokenResponse.getBody().getAccessToken());
			// headers.add("Authorization", "Bearer" + tokenResponse.getBody().getAccessToken());
			
			DomainSearchWebApiV2ModelsSearchParameters listingBody = new DomainSearchWebApiV2ModelsSearchParameters();
			listingBody.setListingType(ListingType.SALE.name());
			listingBody.setPropertyTypes(Arrays.asList("House","NewApartments"));
			listingBody.setMinBedrooms(2);
			listingBody.setMinCarspaces(1);
			Location location = new Location();
			location.setState(State.NSW.toString());
			location.setSuburb("Erskineville");
			listingBody.setLocations(Arrays.asList(location));
			
			HttpEntity<Object> listingRequest = new HttpEntity<Object>(listingBody, headers);
			
			uriBuilder = new URIBuilder();
			uriBuilder.setScheme(protocol).setHost("api.domain.com.au").setPath(listingsResidentialSearchUrl);
			uri = uriBuilder.build();
			System.out.println(uri.toString());
			
			ResponseEntity<List<DomainSearchContractsV2SearchResult>> listingResponse = restTemplate.exchange(uri,
					HttpMethod.POST, listingRequest,
					new ParameterizedTypeReference<List<DomainSearchContractsV2SearchResult>>() {
					});
			System.out.println(listingResponse);
			
			
		} catch (RestClientException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		//HttpHeaders headers = createHeaders(domainOauthClientId, domainOauthClientSecret)

		return "home";
	}
	

	HttpHeaders createHeaders(String clientId, String clientSecret) {
		return new HttpHeaders() {
			private static final long serialVersionUID = -5862419048793952223L;

			{
				String auth = clientId + ":" + clientSecret;
				String authHeader = "Basic " + new String(Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII"))));
				set("Authorization", authHeader);
			}
		};
	}
}
