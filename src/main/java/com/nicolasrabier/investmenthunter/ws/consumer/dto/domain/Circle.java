
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
@JsonPropertyOrder({ "center", "radiusInMeters" })
public class Circle {

	@JsonProperty("center")
	private Center center;
	@JsonProperty("radiusInMeters")
	private Integer radiusInMeters;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("center")
	public Center getCenter() {
		return center;
	}

	@JsonProperty("center")
	public void setCenter(Center center) {
		this.center = center;
	}

	@JsonProperty("radiusInMeters")
	public Integer getRadiusInMeters() {
		return radiusInMeters;
	}

	@JsonProperty("radiusInMeters")
	public void setRadiusInMeters(Integer radiusInMeters) {
		this.radiusInMeters = radiusInMeters;
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
