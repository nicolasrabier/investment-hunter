package com.nicolasrabier.investmenthunter.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class WebServiceCall extends AuditableEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Generated
	private long id;
	
	@Column(nullable = false)
	@NonNull
	private String url;
	
	@Column(nullable = false)
	@NonNull
	private String method;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	@NonNull
	private String requestEntity;
	
	@Column(nullable = true)
	private Integer statusCode;
	
	@Lob
	@Column(columnDefinition = "TEXT")
	private String responseEntity;
	
	
}
