package com.nicolasrabier.investmenthunter.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Configuration extends AuditableEntity{

	@Id
	private long id;
	
	@Column(nullable = true)
	private String domainToken;

	@Column(nullable = true)
	private Integer domainTokenExpiryIn;
	
	
}
