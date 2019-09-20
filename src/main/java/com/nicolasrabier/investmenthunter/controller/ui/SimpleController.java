package com.nicolasrabier.investmenthunter.controller.ui;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;

import com.nicolasrabier.investmenthunter.service.ws.DomainCallManager;
import com.nicolasrabier.investmenthunter.utils.FinanceUtils;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Center;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Circle;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.DomainSearchContractsV2SearchResult;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.DomainSearchWebApiV2ModelsSearchParameters;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.GeoWindow;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Listing;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Location;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.Medium;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.PriceDetails;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.PropertyDetails;
import com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.type.ListingType;

@Controller
public class SimpleController {

	static String ret = "\r\n";

	Logger logger = LoggerFactory.getLogger(SimpleController.class);

	@Value("${spring.application.name}")
	String appName;

	@Autowired
	private DomainCallManager wsCallManager;

	@Autowired
	private FinanceUtils financeUtils;

	// TODO: create a web form with the following fields:
	// deposit
	// interest rate
	// number of years

	// business idea:
	// offer to individual the possibility to search an investment property based
	// on their monthly income (or amount they're willing to spend)
	// max emi limit

	// group properties into object
	@Value("${finance.max.emi}")
	BigDecimal maxEmi;

	@Value("${finance.deposit}")
	BigDecimal deposit;

	@Value("${finance.interest.rate}")
	BigDecimal interestRate;

	@Value("${finance.installment.years}")
	Integer installmentYears;

	@Value("${search.criteria.property.type}")
	String[] propertyTypesArray;

	@Value("${search.criteria.state}")
	String state;

	@Value("${search.criteria.region}")
	String region;

	@Value("${search.criteria.suburb}")
	String suburb;

	@Value("${search.criteria.postcode}")
	String postcode;

	@Value("${search.criteria.min.bedrooms}")
	Integer minBedrooms;

	@Value("${search.criteria.max.bedrooms}")
	Integer maxBedrooms;

	@Value("${search.criteria.min.carspaces}")
	Integer minCarspaces;

	@Value("${search.criteria.max.carspaces}")
	Integer maxCarspaces;

	@GetMapping("/")
	public String homePage(Model model) throws URISyntaxException {
		model.addAttribute("appName", appName);

		/*
		 * TODO: set them on the webui search parameters
		 */
		List<String> propertyTypes = Arrays.asList(propertyTypesArray);
		try {

			// prepare query
			DomainSearchWebApiV2ModelsSearchParameters listingBody = new DomainSearchWebApiV2ModelsSearchParameters();
			listingBody.setListingType(ListingType.SALE.name());
			listingBody.setPropertyTypes(propertyTypes);
			listingBody.setMinBedrooms(minBedrooms);
			listingBody.setMinCarspaces(1);
			Location location = new Location();
			if (state != null)
				location.setState(state);
			if (region != null)
				location.setRegion(region);
			if (suburb != null)
				location.setSuburb(suburb);
			if (postcode != null)
				location.setPostCode(postcode);
			// location.setIncludeSurroundingSuburbs(Boolean.TRUE);
			listingBody.setLocations(Arrays.asList(location));
			listingBody.setPageSize(200);

			List<DomainSearchContractsV2SearchResult> propertiesList = wsCallManager.getListing(listingBody);
			printSearchParameters(listingBody);
			System.out.println("Number of properties found: " + propertiesList.size());

			for (DomainSearchContractsV2SearchResult res : propertiesList) {

				Listing listing = res.getListing();
				List<Listing> propertyList = listing != null ? Arrays.asList(listing) : res.getListings();

				for (Listing property : propertyList) {

					if (property == null || property.getPriceDetails() == null) {
						continue;
					}
					// set global interest rate + deposit + number of years
					// get price & calculate EMI for this property
					PriceDetails pd = property.getPriceDetails();
					Integer price = pd.getPrice() != null ? pd.getPrice()
							: (pd.getPriceTo() != null ? pd.getPriceTo() : null);
					if (price != null) {
						BigDecimal principal = new BigDecimal(price).subtract(deposit);
						BigDecimal emi = financeUtils.getEMI(principal, interestRate, installmentYears.intValue());

						PropertyDetails propd = property.getPropertyDetails();

						listingBody = new DomainSearchWebApiV2ModelsSearchParameters();
						listingBody.setListingType(ListingType.RENT.name());
						listingBody.setPropertyTypes(propd.getAllPropertyTypes());
						listingBody.setMinBedrooms(propd.getBedrooms());
						listingBody.setMaxBedrooms(propd.getBedrooms());
						listingBody.setMinBathrooms(propd.getBathrooms());
						listingBody.setMaxBathrooms(propd.getBathrooms());
						listingBody.setMinCarspaces(propd.getCarspaces());
						listingBody.setMaxCarspaces(propd.getCarspaces());
						listingBody.setMinPrice(emi.divide(new BigDecimal(4)).intValue());

						Center cen = new Center();
						cen.setLat(propd.getLatitude());
						cen.setLon(propd.getLongitude());

						Circle c = new Circle();
						c.setCenter(cen);
						c.setRadiusInMeters(1000);

						GeoWindow gw = new GeoWindow();
						gw.setCircle(c);
						listingBody.setGeoWindow(gw);

						List<DomainSearchContractsV2SearchResult> rentalPropertiesList = wsCallManager
								.getListing(listingBody);
						if (rentalPropertiesList.size() > 0) {
							printListing(property, emi.doubleValue());
							System.out.println(rentalPropertiesList.size());
						}

					}
				}
			}

		} catch (RestClientException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("processing finished");
		return "home";
	}

	private void printSearchParameters(DomainSearchWebApiV2ModelsSearchParameters listingBody) {
		StringBuilder sb = new StringBuilder();

		sb.append("Listing Type: ").append(listingBody.getListingType().toString()).append(ret);
		sb.append("Property Type: ").append(listingBody.getPropertyTypes().toString()).append(ret);
		sb.append("minBedrooms: ").append(listingBody.getMinBedrooms()).append(ret);
		sb.append("maxBedrooms: ").append(listingBody.getMaxBedrooms()).append(ret);
		sb.append("MinCarspaces: ").append(listingBody.getMinCarspaces()).append(ret);
		sb.append("MaxCarspaces: ").append(listingBody.getMaxCarspaces()).append(ret);
		sb.append("State: ").append(listingBody.getLocations().get(0).getState()).append(ret);
		sb.append("Region: ").append(listingBody.getLocations().get(0).getRegion()).append(ret);
		sb.append("Suburb: ").append(listingBody.getLocations().get(0).getSuburb()).append(ret);
		sb.append("Postcode: ").append(listingBody.getLocations().get(0).getPostCode()).append(ret);

		System.out.println(sb.toString());
	}

	private void printListing(Listing property, Double emi) {
		StringBuilder sb = new StringBuilder();

		sb.append("Headline: ").append(property.getHeadline()).append(ret);
		sb.append("https://www.domain.com.au/").append(property.getListingSlug()).append(ret);
		if (property.getAdditionalProperties() != null) {
			for (String key : property.getAdditionalProperties().keySet()) {
				sb.append(key).append(": ").append(property.getAdditionalProperties().get(key)).append(ret);
			}
		}
		if (property.getMedia() != null) {
			int count = 1;
			for (Medium m : property.getMedia()) {
				sb.append(count++).append(" Photo: ").append(m.getUrl()).append(ret);
			}
		}
		PriceDetails pd = property.getPriceDetails();
		sb.append("DisplayPrice: ").append(pd.getDisplayPrice()).append(ret);
		sb.append("Price: ").append(pd.getPrice()).append(ret);
		sb.append("PriceFrom: ").append(pd.getPriceFrom()).append(ret);
		sb.append("PriceTo: ").append(pd.getPriceTo()).append(ret);

		if (emi != null)
			sb.append("EMI: ").append(emi).append(ret);

		sb.append("Latitude :").append(property.getPropertyDetails().getLatitude()).append(ret);
		sb.append("Longitude :").append(property.getPropertyDetails().getLongitude()).append(ret);

		System.out.println(sb.toString());

	}

}
