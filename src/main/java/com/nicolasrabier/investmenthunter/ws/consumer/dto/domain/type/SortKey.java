package com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.type;

import lombok.Getter;
import lombok.Setter;

public enum SortKey {
	DEFAULT("Default"), SUBURB("Suburb"), PRICE("Price"), DATE_UPDATED("DateUpdated"),
	INSPECTION_TIME("InspectionTime"), PROXIMITY("Proximity"), SOLD_DATE("SoldDate");

	@Getter
	@Setter
	private String name;

	private SortKey(String name) {
		this.name = name;
	}
}
