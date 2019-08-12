
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
    "promoLevel",
    "listingType",
    "id",
    "projectId",
    "advertiser",
    "priceDetails",
    "media",
    "propertyDetails",
    "headline",
    "summaryDescription",
    "hasFloorplan",
    "hasVideo",
    "labels",
    "auctionSchedule",
    "inspectionSchedule",
    "soldData",
    "listingSlug"
})
public class Listing {

    @JsonProperty("promoLevel")
    private String promoLevel;
    @JsonProperty("listingType")
    private String listingType;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("projectId")
    private Integer projectId;
    @JsonProperty("advertiser")
    private Advertiser advertiser;
    @JsonProperty("priceDetails")
    private PriceDetails priceDetails;
    @JsonProperty("media")
    private List<Medium> media = null;
    @JsonProperty("propertyDetails")
    private PropertyDetails propertyDetails;
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("summaryDescription")
    private String summaryDescription;
    @JsonProperty("hasFloorplan")
    private Boolean hasFloorplan;
    @JsonProperty("hasVideo")
    private Boolean hasVideo;
    @JsonProperty("labels")
    private List<String> labels = null;
    @JsonProperty("auctionSchedule")
    private AuctionSchedule auctionSchedule;
    @JsonProperty("inspectionSchedule")
    private InspectionSchedule inspectionSchedule;
    @JsonProperty("soldData")
    private SoldData soldData;
    @JsonProperty("listingSlug")
    private String listingSlug;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("promoLevel")
    public String getPromoLevel() {
        return promoLevel;
    }

    @JsonProperty("promoLevel")
    public void setPromoLevel(String promoLevel) {
        this.promoLevel = promoLevel;
    }

    @JsonProperty("listingType")
    public String getListingType() {
        return listingType;
    }

    @JsonProperty("listingType")
    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("projectId")
    public Integer getProjectId() {
        return projectId;
    }

    @JsonProperty("projectId")
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("advertiser")
    public Advertiser getAdvertiser() {
        return advertiser;
    }

    @JsonProperty("advertiser")
    public void setAdvertiser(Advertiser advertiser) {
        this.advertiser = advertiser;
    }

    @JsonProperty("priceDetails")
    public PriceDetails getPriceDetails() {
        return priceDetails;
    }

    @JsonProperty("priceDetails")
    public void setPriceDetails(PriceDetails priceDetails) {
        this.priceDetails = priceDetails;
    }

    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @JsonProperty("propertyDetails")
    public PropertyDetails getPropertyDetails() {
        return propertyDetails;
    }

    @JsonProperty("propertyDetails")
    public void setPropertyDetails(PropertyDetails propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    @JsonProperty("headline")
    public String getHeadline() {
        return headline;
    }

    @JsonProperty("headline")
    public void setHeadline(String headline) {
        this.headline = headline;
    }

    @JsonProperty("summaryDescription")
    public String getSummaryDescription() {
        return summaryDescription;
    }

    @JsonProperty("summaryDescription")
    public void setSummaryDescription(String summaryDescription) {
        this.summaryDescription = summaryDescription;
    }

    @JsonProperty("hasFloorplan")
    public Boolean getHasFloorplan() {
        return hasFloorplan;
    }

    @JsonProperty("hasFloorplan")
    public void setHasFloorplan(Boolean hasFloorplan) {
        this.hasFloorplan = hasFloorplan;
    }

    @JsonProperty("hasVideo")
    public Boolean getHasVideo() {
        return hasVideo;
    }

    @JsonProperty("hasVideo")
    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    @JsonProperty("labels")
    public List<String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    @JsonProperty("auctionSchedule")
    public AuctionSchedule getAuctionSchedule() {
        return auctionSchedule;
    }

    @JsonProperty("auctionSchedule")
    public void setAuctionSchedule(AuctionSchedule auctionSchedule) {
        this.auctionSchedule = auctionSchedule;
    }

    @JsonProperty("inspectionSchedule")
    public InspectionSchedule getInspectionSchedule() {
        return inspectionSchedule;
    }

    @JsonProperty("inspectionSchedule")
    public void setInspectionSchedule(InspectionSchedule inspectionSchedule) {
        this.inspectionSchedule = inspectionSchedule;
    }

    @JsonProperty("soldData")
    public SoldData getSoldData() {
        return soldData;
    }

    @JsonProperty("soldData")
    public void setSoldData(SoldData soldData) {
        this.soldData = soldData;
    }

    @JsonProperty("listingSlug")
    public String getListingSlug() {
        return listingSlug;
    }

    @JsonProperty("listingSlug")
    public void setListingSlug(String listingSlug) {
        this.listingSlug = listingSlug;
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
