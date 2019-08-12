
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
    "id",
    "name",
    "logoUrl",
    "preferredColourHex",
    "bannerUrl",
    "contacts"
})
public class Advertiser_ {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("logoUrl")
    private String logoUrl;
    @JsonProperty("preferredColourHex")
    private String preferredColourHex;
    @JsonProperty("bannerUrl")
    private String bannerUrl;
    @JsonProperty("contacts")
    private List<Contact_> contacts = null;
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

    @JsonProperty("logoUrl")
    public String getLogoUrl() {
        return logoUrl;
    }

    @JsonProperty("logoUrl")
    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @JsonProperty("preferredColourHex")
    public String getPreferredColourHex() {
        return preferredColourHex;
    }

    @JsonProperty("preferredColourHex")
    public void setPreferredColourHex(String preferredColourHex) {
        this.preferredColourHex = preferredColourHex;
    }

    @JsonProperty("bannerUrl")
    public String getBannerUrl() {
        return bannerUrl;
    }

    @JsonProperty("bannerUrl")
    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @JsonProperty("contacts")
    public List<Contact_> getContacts() {
        return contacts;
    }

    @JsonProperty("contacts")
    public void setContacts(List<Contact_> contacts) {
        this.contacts = contacts;
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
