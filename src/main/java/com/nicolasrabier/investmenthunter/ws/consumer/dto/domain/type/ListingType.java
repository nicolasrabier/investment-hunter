package com.nicolasrabier.investmenthunter.ws.consumer.dto.domain.type;

import lombok.Getter;
import lombok.Setter;

public enum ListingType {
	SALE("Sale"), RENT("Rent"), SHARE("Share"), SOLD("Sold"), NEW_HOMES("NewHomes"),;

	@Getter
	@Setter
	private String name;

	private ListingType(String name) {
		this.name = name;
	}
}
