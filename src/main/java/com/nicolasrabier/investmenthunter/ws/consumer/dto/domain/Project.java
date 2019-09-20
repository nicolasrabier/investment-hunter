
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
    "state",
    "id",
    "name",
    "bannerUrl",
    "preferredColorHex",
    "logoUrl",
    "labels",
    "displayableAddress",
    "suburb",
    "features",
    "media",
    "projectSlug"
})
public class Project {

    @JsonProperty("promoLevel")
    private String promoLevel;
    @JsonProperty("state")
    private String state;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("bannerUrl")
    private String bannerUrl;
    @JsonProperty("preferredColorHex")
    private String preferredColorHex;
    @JsonProperty("logoUrl")
    private String logoUrl;
    @JsonProperty("labels")
    private List<String> labels = null;
    @JsonProperty("displayableAddress")
    private String displayableAddress;
    @JsonProperty("suburb")
    private String suburb;
    @JsonProperty("features")
    private List<String> features = null;
    @JsonProperty("media")
    private List<Medium> media = null;
    @JsonProperty("projectSlug")
    private String projectSlug;
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

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("bannerUrl")
    public String getBannerUrl() {
        return bannerUrl;
    }

    @JsonProperty("bannerUrl")
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @JsonProperty("preferredColorHex")
    public String getPreferredColorHex() {
        return preferredColorHex;
    }

    @JsonProperty("preferredColorHex")
    public void setPreferredColorHex(String preferredColorHex) {
        this.preferredColorHex = preferredColorHex;
    }

    @JsonProperty("logoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty("logoUrl")
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @JsonProperty("labels")
    public List<String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    @JsonProperty("displayableAddress")
    public String getDisplayableAddress() {
        return displayableAddress;
    }

    @JsonProperty("displayableAddress")
    public void setDisplayableAddress(String displayableAddress) {
        this.displayableAddress = displayableAddress;
    }

    @JsonProperty("suburb")
    public String getSuburb() {
        return suburb;
    }

    @JsonProperty("suburb")
    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    @JsonProperty("features")
    public List<String> getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(List<String> features) {
        this.features = features;
    }

    @JsonProperty("media")
    public List<Medium> getMedia() {
        return media;
    }

    @JsonProperty("media")
    public void setMedia(List<Medium> media) {
        this.media = media;
    }

    @JsonProperty("projectSlug")
    public String getProjectSlug() {
        return projectSlug;
    }

    @JsonProperty("projectSlug")
    public void setProjectSlug(String projectSlug) {
        this.projectSlug = projectSlug;
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
