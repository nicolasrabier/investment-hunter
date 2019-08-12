
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
@JsonPropertyOrder({
    "state",
    "features",
    "propertyType",
    "allPropertyTypes",
    "bathrooms",
    "bedrooms",
    "carspaces",
    "unitNumber",
    "streetNumber",
    "street",
    "area",
    "region",
    "suburb",
    "postcode",
    "displayableAddress",
    "latitude",
    "longitude",
    "landArea",
    "buildingArea",
    "onlyShowProperties",
    "displayAddressType",
    "isRural",
    "isNew"
})
public class PropertyDetails {

    @JsonProperty("state")
    private String state;
    @JsonProperty("features")
    private List<String> features = null;
    @JsonProperty("propertyType")
    private String propertyType;
    @JsonProperty("allPropertyTypes")
    private List<String> allPropertyTypes = null;
    @JsonProperty("bathrooms")
    private Integer bathrooms;
    @JsonProperty("bedrooms")
    private Integer bedrooms;
    @JsonProperty("carspaces")
    private Integer carspaces;
    @JsonProperty("unitNumber")
    private String unitNumber;
    @JsonProperty("streetNumber")
    private String streetNumber;
    @JsonProperty("street")
    private String street;
    @JsonProperty("area")
    private String area;
    @JsonProperty("region")
    private String region;
    @JsonProperty("suburb")
    private String suburb;
    @JsonProperty("postcode")
    private String postcode;
    @JsonProperty("displayableAddress")
    private String displayableAddress;
    @JsonProperty("latitude")
    private Integer latitude;
    @JsonProperty("longitude")
    private Integer longitude;
    @JsonProperty("landArea")
    private Integer landArea;
    @JsonProperty("buildingArea")
    private Integer buildingArea;
    @JsonProperty("onlyShowProperties")
    private List<String> onlyShowProperties = null;
    @JsonProperty("displayAddressType")
    private String displayAddressType;
    @JsonProperty("isRural")
    private Boolean isRural;
    @JsonProperty("isNew")
    private Boolean isNew;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("features")
    public List<String> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @JsonProperty("propertyType")
    public String getPropertyType() {
        return propertyType;
    }

    @JsonProperty("propertyType")
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @JsonProperty("allPropertyTypes")
    public List<String> getAllPropertyTypes() {
        return allPropertyTypes;
    }

    @JsonProperty("allPropertyTypes")
    public void setAllPropertyTypes(List<String> allPropertyTypes) {
        this.allPropertyTypes = allPropertyTypes;
    }

    @JsonProperty("bathrooms")
    public Integer getBathrooms() {
        return bathrooms;
    }

    @JsonProperty("bathrooms")
    public void setBathrooms(Integer bathrooms) {
        this.bathrooms = bathrooms;
    }

    @JsonProperty("bedrooms")
    public Integer getBedrooms() {
        return bedrooms;
    }

    @JsonProperty("bedrooms")
    public void setBedrooms(Integer bedrooms) {
        this.bedrooms = bedrooms;
    }

    @JsonProperty("carspaces")
    public Integer getCarspaces() {
        return carspaces;
    }

    @JsonProperty("carspaces")
    public void setCarspaces(Integer carspaces) {
        this.carspaces = carspaces;
    }

    @JsonProperty("unitNumber")
    public String getUnitNumber() {
        return unitNumber;
    }

    @JsonProperty("unitNumber")
    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    @JsonProperty("streetNumber")
    public String getStreetNumber() {
        return streetNumber;
    }

    @JsonProperty("streetNumber")
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    @JsonProperty("area")
    public String getArea() {
        return area;
    }

    @JsonProperty("area")
    public void setArea(String area) {
        this.area = area;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("suburb")
    public String getSuburb() {
        return suburb;
    }

    @JsonProperty("suburb")
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @JsonProperty("postcode")
    public String getPostcode() {
        return postcode;
    }

    @JsonProperty("postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @JsonProperty("displayableAddress")
    public String getDisplayableAddress() {
        return displayableAddress;
    }

    @JsonProperty("displayableAddress")
    public void setDisplayableAddress(String displayableAddress) {
        this.displayableAddress = displayableAddress;
    }

    @JsonProperty("latitude")
    public Integer getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public Integer getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("landArea")
    public Integer getLandArea() {
        return landArea;
    }

    @JsonProperty("landArea")
    public void setLandArea(Integer landArea) {
        this.landArea = landArea;
    }

    @JsonProperty("buildingArea")
    public Integer getBuildingArea() {
        return buildingArea;
    }

    @JsonProperty("buildingArea")
    public void setBuildingArea(Integer buildingArea) {
        this.buildingArea = buildingArea;
    }

    @JsonProperty("onlyShowProperties")
    public List<String> getOnlyShowProperties() {
        return onlyShowProperties;
    }

    @JsonProperty("onlyShowProperties")
    public void setOnlyShowProperties(List<String> onlyShowProperties) {
        this.onlyShowProperties = onlyShowProperties;
    }

    @JsonProperty("displayAddressType")
    public String getDisplayAddressType() {
        return displayAddressType;
    }

    @JsonProperty("displayAddressType")
    public void setDisplayAddressType(String displayAddressType) {
        this.displayAddressType = displayAddressType;
    }

    @JsonProperty("isRural")
    public Boolean getIsRural() {
        return isRural;
    }

    @JsonProperty("isRural")
    public void setIsRural(Boolean isRural) {
        this.isRural = isRural;
    }

    @JsonProperty("isNew")
    public Boolean getIsNew() {
        return isNew;
    }

    @JsonProperty("isNew")
    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
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
