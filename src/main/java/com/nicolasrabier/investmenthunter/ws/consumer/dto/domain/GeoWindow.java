
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
@JsonPropertyOrder({ "box", "circle", "polygon" })
public class GeoWindow {

	@JsonProperty("box")
	private Box box;
	@JsonProperty("circle")
	private Circle circle;
	@JsonProperty("polygon")
	private Polygon polygon;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("box")
	public Box getBox() {
		return box;
	}

	@JsonProperty("box")
	public void setBox(Box box) {
		this.box = box;
	}

	@JsonProperty("circle")
	public Circle getCircle() {
		return circle;
	}

	@JsonProperty("circle")
	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	@JsonProperty("polygon")
	public Polygon getPolygon() {
		return polygon;
	}

	@JsonProperty("polygon")
	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
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
