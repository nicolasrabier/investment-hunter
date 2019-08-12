
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
    "openingTime",
    "closingTime"
})
public class Time_ {

    @JsonProperty("openingTime")
    private String openingTime;
    @JsonProperty("closingTime")
    private String closingTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("openingTime")
    public String getOpeningTime() {
        return openingTime;
    }

    @JsonProperty("openingTime")
    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    @JsonProperty("closingTime")
    public String getClosingTime() {
        return closingTime;
    }

    @JsonProperty("closingTime")
    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
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
