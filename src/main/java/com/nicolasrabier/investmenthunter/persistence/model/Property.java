package com.nicolasrabier.investmenthunter.persistence.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Property {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@Column(nullable = false)
		private BigDecimal price;
		
		@Column(nullable = false)
		private String address;
}
