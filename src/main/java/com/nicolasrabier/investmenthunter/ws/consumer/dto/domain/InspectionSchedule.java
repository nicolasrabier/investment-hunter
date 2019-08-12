
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
    "byAppointment",
    "recurring",
    "times"
})
public class InspectionSchedule {

    @JsonProperty("byAppointment")
    private Boolean byAppointment;
    @JsonProperty("recurring")
    private Boolean recurring;
    @JsonProperty("times")
    private List<Time> times = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("byAppointment")
    public Boolean getByAppointment() {
        return byAppointment;
    }

    @JsonProperty("byAppointment")
    public void setByAppointment(Boolean byAppointment) {
        this.byAppointment = byAppointment;
    }

    @JsonProperty("recurring")
    public Boolean getRecurring() {
        return recurring;
    }

    @JsonProperty("recurring")
    public void setRecurring(Boolean recurring) {
        this.recurring = recurring;
    }

    @JsonProperty("times")
    public List<Time> getTimes() {
        return times;
    }

    @JsonProperty("times")
    public void setTimes(List<Time> times) {
        this.times = times;
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
