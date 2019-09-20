package com.nicolasrabier.investmenthunter.persistence.model;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AuditableEntity {

	@Column(nullable = false, updatable = false)
	@CreatedDate
    private long createdDate;
	
	@CreatedBy
    private String createdBy;
	
	@Column(nullable = true)
	@LastModifiedDate
    private long updatedDate;
	
	@LastModifiedBy
    private String updatedBy;
	
	
}
