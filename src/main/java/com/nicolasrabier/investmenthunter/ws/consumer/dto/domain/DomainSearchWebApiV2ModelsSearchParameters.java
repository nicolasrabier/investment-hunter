
package com.nicolasrabier.investmenthunter.ws.consumer.dto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "listingType", "propertyTypes", "propertyFeatures", "listingAttributes", "propertyEstablishedType",
		"minBedrooms", "maxBedrooms", "minBathrooms", "maxBathrooms", "minCarspaces", "maxCarspaces", "minPrice",
		"maxPrice", "minLandArea", "maxLandArea", "advertiserIds", "adIds", "excludeAdIds", "locations",
		"locationTerms", "keywords", "newDevOnly", "inspectionFrom", "inspectionTo", "auctionFrom", "auctionTo",
		"ruralOnly", "excludePriceWithheld", "sort", "page", "pageSize", "geoWindow", "updatedSince" })
public class DomainSearchWebApiV2ModelsSearchParameters {

	@JsonProperty("listingType")
	private String listingType;
	@JsonProperty("propertyTypes")
	private List<String> propertyTypes = null;
	@JsonProperty("propertyFeatures")
	private List<String> propertyFeatures = null;
	@JsonProperty("listingAttributes")
	private List<String> listingAttributes = null;
	@JsonProperty("propertyEstablishedType")
	private String propertyEstablishedType;
	@JsonProperty("minBedrooms")
	private Integer minBedrooms;
	@JsonProperty("maxBedrooms")
	private Integer maxBedrooms;
	@JsonProperty("minBathrooms")
	private Integer minBathrooms;
	@JsonProperty("maxBathrooms")
	private Integer maxBathrooms;
	@JsonProperty("minCarspaces")
	private Integer minCarspaces;
	@JsonProperty("maxCarspaces")
	private Integer maxCarspaces;
	@JsonProperty("minPrice")
	private Integer minPrice;
	@JsonProperty("maxPrice")
	private Integer maxPrice;
	@JsonProperty("minLandArea")
	private Integer minLandArea;
	@JsonProperty("maxLandArea")
	private Integer maxLandArea;
	@JsonProperty("advertiserIds")
	private List<Integer> advertiserIds = null;
	@JsonProperty("adIds")
	private List<Integer> adIds = null;
	@JsonProperty("excludeAdIds")
	private List<Integer> excludeAdIds = null;
	@JsonProperty("locations")
	private List<Location> locations = null;
	@JsonProperty("locationTerms")
	private String locationTerms;
	@JsonProperty("keywords")
	private List<String> keywords = null;
	@JsonProperty("newDevOnly")
	private Boolean newDevOnly;
	@JsonProperty("inspectionFrom")
	private String inspectionFrom;
	@JsonProperty("inspectionTo")
	private String inspectionTo;
	@JsonProperty("auctionFrom")
	private String auctionFrom;
	@JsonProperty("auctionTo")
	private String auctionTo;
	@JsonProperty("ruralOnly")
	private Boolean ruralOnly;
	@JsonProperty("excludePriceWithheld")
	private Boolean excludePriceWithheld;
	@JsonProperty("sort")
	private Sort sort;
	@JsonProperty("page")
	private Integer page;
	@JsonProperty("pageSize")
	private Integer pageSize;
	@JsonProperty("geoWindow")
	private GeoWindow geoWindow;
	@JsonProperty("updatedSince")
	private String updatedSince;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("listingType")
	public String getListingType() {
		return listingType;
	}

	@JsonProperty("listingType")
	public void setListingType(String listingType) {
		this.listingType = listingType;
	}

	@JsonProperty("propertyTypes")
	public List<String> getPropertyTypes() {
		return propertyTypes;
	}

	@JsonProperty("propertyTypes")
	public void setPropertyTypes(List<String> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}

	@JsonProperty("propertyFeatures")
	public List<String> getPropertyFeatures() {
		return propertyFeatures;
	}

	@JsonProperty("propertyFeatures")
	public void setPropertyFeatures(List<String> propertyFeatures) {
		this.propertyFeatures = propertyFeatures;
	}

	@JsonProperty("listingAttributes")
	public List<String> getListingAttributes() {
		return listingAttributes;
	}

	@JsonProperty("listingAttributes")
	public void setListingAttributes(List<String> listingAttributes) {
		this.listingAttributes = listingAttributes;
	}

	@JsonProperty("propertyEstablishedType")
	public String getPropertyEstablishedType() {
		return propertyEstablishedType;
	}

	@JsonProperty("propertyEstablishedType")
	public void setPropertyEstablishedType(String propertyEstablishedType) {
		this.propertyEstablishedType = propertyEstablishedType;
	}

	@JsonProperty("minBedrooms")
	public Integer getMinBedrooms() {
		return minBedrooms;
	}

	@JsonProperty("minBedrooms")
	public void setMinBedrooms(Integer minBedrooms) {
		this.minBedrooms = minBedrooms;
	}

	@JsonProperty("maxBedrooms")
	public Integer getMaxBedrooms() {
		return maxBedrooms;
	}

	@JsonProperty("maxBedrooms")
	public void setMaxBedrooms(Integer maxBedrooms) {
		this.maxBedrooms = maxBedrooms;
	}

	@JsonProperty("minBathrooms")
	public Integer getMinBathrooms() {
		return minBathrooms;
	}

	@JsonProperty("minBathrooms")
	public void setMinBathrooms(Integer minBathrooms) {
		this.minBathrooms = minBathrooms;
	}

	@JsonProperty("maxBathrooms")
	public Integer getMaxBathrooms() {
		return maxBathrooms;
	}

	@JsonProperty("maxBathrooms")
	public void setMaxBathrooms(Integer maxBathrooms) {
		this.maxBathrooms = maxBathrooms;
	}

	@JsonProperty("minCarspaces")
	public Integer getMinCarspaces() {
		return minCarspaces;
	}

	@JsonProperty("minCarspaces")
	public void setMinCarspaces(Integer minCarspaces) {
		this.minCarspaces = minCarspaces;
	}

	@JsonProperty("maxCarspaces")
	public Integer getMaxCarspaces() {
		return maxCarspaces;
	}

	@JsonProperty("maxCarspaces")
	public void setMaxCarspaces(Integer maxCarspaces) {
		this.maxCarspaces = maxCarspaces;
	}

	@JsonProperty("minPrice")
	public Integer getMinPrice() {
		return minPrice;
	}

	@JsonProperty("minPrice")
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	@JsonProperty("maxPrice")
	public Integer getMaxPrice() {
		return maxPrice;
	}

	@JsonProperty("maxPrice")
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	@JsonProperty("minLandArea")
	public Integer getMinLandArea() {
		return minLandArea;
	}

	@JsonProperty("minLandArea")
	public void setMinLandArea(Integer minLandArea) {
		this.minLandArea = minLandArea;
	}

	@JsonProperty("maxLandArea")
	public Integer getMaxLandArea() {
		return maxLandArea;
	}

	@JsonProperty("maxLandArea")
	public void setMaxLandArea(Integer maxLandArea) {
		this.maxLandArea = maxLandArea;
	}

	@JsonProperty("advertiserIds")
	public List<Integer> getAdvertiserIds() {
		return advertiserIds;
	}

	@JsonProperty("advertiserIds")
	public void setAdvertiserIds(List<Integer> advertiserIds) {
		this.advertiserIds = advertiserIds;
	}

	@JsonProperty("adIds")
	public List<Integer> getAdIds() {
		return adIds;
	}

	@JsonProperty("adIds")
	public void setAdIds(List<Integer> adIds) {
		this.adIds = adIds;
	}

	@JsonProperty("excludeAdIds")
	public List<Integer> getExcludeAdIds() {
		return excludeAdIds;
	}

	@JsonProperty("excludeAdIds")
	public void setExcludeAdIds(List<Integer> excludeAdIds) {
		this.excludeAdIds = excludeAdIds;
	}

	@JsonProperty("locations")
	public List<Location> getLocations() {
		return locations;
	}

	@JsonProperty("locations")
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@JsonProperty("locationTerms")
	public String getLocationTerms() {
		return locationTerms;
	}

	@JsonProperty("locationTerms")
	public void setLocationTerms(String locationTerms) {
		this.locationTerms = locationTerms;
	}

	@JsonProperty("keywords")
	public List<String> getKeywords() {
		return keywords;
	}

	@JsonProperty("keywords")
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	@JsonProperty("newDevOnly")
	public Boolean getNewDevOnly() {
		return newDevOnly;
	}

	@JsonProperty("newDevOnly")
	public void setNewDevOnly(Boolean newDevOnly) {
		this.newDevOnly = newDevOnly;
	}

	@JsonProperty("inspectionFrom")
	public String getInspectionFrom() {
		return inspectionFrom;
	}

	@JsonProperty("inspectionFrom")
	public void setInspectionFrom(String inspectionFrom) {
		this.inspectionFrom = inspectionFrom;
	}

	@JsonProperty("inspectionTo")
	public String getInspectionTo() {
		return inspectionTo;
	}

	@JsonProperty("inspectionTo")
	public void setInspectionTo(String inspectionTo) {
		this.inspectionTo = inspectionTo;
	}

	@JsonProperty("auctionFrom")
	public String getAuctionFrom() {
		return auctionFrom;
	}

	@JsonProperty("auctionFrom")
	public void setAuctionFrom(String auctionFrom) {
		this.auctionFrom = auctionFrom;
	}

	@JsonProperty("auctionTo")
	public String getAuctionTo() {
		return auctionTo;
	}

	@JsonProperty("auctionTo")
	public void setAuctionTo(String auctionTo) {
		this.auctionTo = auctionTo;
	}

	@JsonProperty("ruralOnly")
	public Boolean getRuralOnly() {
		return ruralOnly;
	}

	@JsonProperty("ruralOnly")
	public void setRuralOnly(Boolean ruralOnly) {
		this.ruralOnly = ruralOnly;
	}

	@JsonProperty("excludePriceWithheld")
	public Boolean getExcludePriceWithheld() {
		return excludePriceWithheld;
	}

	@JsonProperty("excludePriceWithheld")
	public void setExcludePriceWithheld(Boolean excludePriceWithheld) {
		this.excludePriceWithheld = excludePriceWithheld;
	}

	@JsonProperty("sort")
	public Sort getSort() {
		return sort;
	}

	@JsonProperty("sort")
	public void setSort(Sort sort) {
		this.sort = sort;
	}

	@JsonProperty("page")
	public Integer getPage() {
		return page;
	}

	@JsonProperty("page")
	public void setPage(Integer page) {
		this.page = page;
	}

	@JsonProperty("pageSize")
	public Integer getPageSize() {
		return pageSize;
	}

	@JsonProperty("pageSize")
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@JsonProperty("geoWindow")
	public GeoWindow getGeoWindow() {
		return geoWindow;
	}

	@JsonProperty("geoWindow")
	public void setGeoWindow(GeoWindow geoWindow) {
		this.geoWindow = geoWindow;
	}

	@JsonProperty("updatedSince")
	public String getUpdatedSince() {
		return updatedSince;
	}

	@JsonProperty("updatedSince")
	public void setUpdatedSince(String updatedSince) {
		this.updatedSince = updatedSince;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
