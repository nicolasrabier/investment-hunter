
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
@JsonPropertyOrder({ "topLeft", "bottomRight" })
public class Box {

	@JsonProperty("topLeft")
	private TopLeft topLeft;
	@JsonProperty("bottomRight")
	private BottomRight bottomRight;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("topLeft")
	public TopLeft getTopLeft() {
		return topLeft;
	}

	@JsonProperty("topLeft")
	public void setTopLeft(TopLeft topLeft) {
		this.topLeft = topLeft;
	}

	@JsonProperty("bottomRight")
	public BottomRight getBottomRight() {
		return bottomRight;
	}

	@JsonProperty("bottomRight")
	public void setBottomRight(BottomRight bottomRight) {
		this.bottomRight = bottomRight;
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
