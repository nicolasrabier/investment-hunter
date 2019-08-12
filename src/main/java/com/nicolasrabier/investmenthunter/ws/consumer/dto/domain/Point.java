
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
@JsonPropertyOrder({ "lat", "lon" })
public class Point {

	@JsonProperty("lat")
	private Integer lat;
	@JsonProperty("lon")
	private Integer lon;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("lat")
	public Integer getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(Integer lat) {
		this.lat = lat;
	}

	@JsonProperty("lon")
	public Integer getLon() {
		return lon;
	}

	@JsonProperty("lon")
	public void setLon(Integer lon) {
		this.lon = lon;
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
