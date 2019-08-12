
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
@JsonPropertyOrder({ "sortKey", "direction", "proximityTo" })
public class Sort {

	@JsonProperty("sortKey")
	private String sortKey;
	@JsonProperty("direction")
	private String direction;
	@JsonProperty("proximityTo")
	private ProximityTo proximityTo;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("sortKey")
	public String getSortKey() {
		return sortKey;
	}

	@JsonProperty("sortKey")
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	@JsonProperty("direction")
	public String getDirection() {
		return direction;
	}

	@JsonProperty("direction")
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@JsonProperty("proximityTo")
	public ProximityTo getProximityTo() {
		return proximityTo;
	}

	@JsonProperty("proximityTo")
	public void setProximityTo(ProximityTo proximityTo) {
		this.proximityTo = proximityTo;
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
