
package com.nicolasrabier.investmenthunter.ws.consumer.dto.domain;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "price",
    "priceFrom",
    "priceTo",
    "displayPrice"
})
public class PriceDetails {

    @JsonProperty("price")
    private Integer price;
    @JsonProperty("priceFrom")
    private Integer priceFrom;
    @JsonProperty("priceTo")
    private Integer priceTo;
    @JsonProperty("displayPrice")
    private String displayPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("priceFrom")
    public Integer getPriceFrom() {
        return priceFrom;
    }

    @JsonProperty("priceFrom")
    public void setPriceFrom(Integer priceFrom) {
        this.priceFrom = priceFrom;
    }

    @JsonProperty("priceTo")
    public Integer getPriceTo() {
        return priceTo;
    }

    @JsonProperty("priceTo")
    public void setPriceTo(Integer priceTo) {
        this.priceTo = priceTo;
    }

    @JsonProperty("displayPrice")
    public String getDisplayPrice() {
        return displayPrice;
    }

    @JsonProperty("displayPrice")
    public void setDisplayPrice(String displayPrice) {
        this.displayPrice = displayPrice;
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
