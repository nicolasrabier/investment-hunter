
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
    "source",
    "saleMethod",
    "soldDate",
    "soldPrice"
})
public class SoldData {

    @JsonProperty("source")
    private String source;
    @JsonProperty("saleMethod")
    private String saleMethod;
    @JsonProperty("soldDate")
    private String soldDate;
    @JsonProperty("soldPrice")
    private Integer soldPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("saleMethod")
    public String getSaleMethod() {
        return saleMethod;
    }

    @JsonProperty("saleMethod")
    public void setSaleMethod(String saleMethod) {
        this.saleMethod = saleMethod;
    }

    @JsonProperty("soldDate")
    public String getSoldDate() {
        return soldDate;
    }

    @JsonProperty("soldDate")
    public void setSoldDate(String soldDate) {
        this.soldDate = soldDate;
    }

    @JsonProperty("soldPrice")
    public Integer getSoldPrice() {
        return soldPrice;
    }

    @JsonProperty("soldPrice")
    public void setSoldPrice(Integer soldPrice) {
        this.soldPrice = soldPrice;
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
