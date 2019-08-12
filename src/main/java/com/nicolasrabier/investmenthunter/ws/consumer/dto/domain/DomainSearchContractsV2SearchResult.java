
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
    "type",
    "listing",
    "listings",
    "project"
})
public class DomainSearchContractsV2SearchResult {

    @JsonProperty("type")
    private String type;
    @JsonProperty("listing")
    private Listing listing;
    @JsonProperty("listings")
    private List<Listing_> listings = null;
    @JsonProperty("project")
    private Project project;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("listing")
    public Listing getListing() {
        return listing;
    }

    @JsonProperty("listing")
    public void setListing(Listing listing) {
        this.listing = listing;
    }

    @JsonProperty("listings")
    public List<Listing_> getListings() {
        return listings;
    }

    @JsonProperty("listings")
    public void setListings(List<Listing_> listings) {
        this.listings = listings;
    }

    @JsonProperty("project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("project")
    public void setProject(Project project) {
        this.project = project;
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
