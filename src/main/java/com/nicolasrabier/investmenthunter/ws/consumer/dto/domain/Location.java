
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
@JsonPropertyOrder({ "state", "region", "area", "suburb", "postCode", "includeSurroundingSuburbs" })
public class Location {

	@JsonProperty("state")
	private String state;
	@JsonProperty("region")
	private String region;
	@JsonProperty("area")
	private String area;
	@JsonProperty("suburb")
	private String suburb;
	@JsonProperty("postCode")
	private String postCode;
	@JsonProperty("includeSurroundingSuburbs")
	private Boolean includeSurroundingSuburbs;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("area")
	public String getArea() {
		return area;
	}

	@JsonProperty("area")
	public void setArea(String area) {
		this.area = area;
	}

	@JsonProperty("suburb")
	public String getSuburb() {
		return suburb;
	}

	@JsonProperty("suburb")
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	@JsonProperty("postCode")
	public String getPostCode() {
		return postCode;
	}

	@JsonProperty("postCode")
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	@JsonProperty("includeSurroundingSuburbs")
	public Boolean getIncludeSurroundingSuburbs() {
		return includeSurroundingSuburbs;
	}

	@JsonProperty("includeSurroundingSuburbs")
	public void setIncludeSurroundingSuburbs(Boolean includeSurroundingSuburbs) {
		this.includeSurroundingSuburbs = includeSurroundingSuburbs;
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
