package com.nicolasrabier.investmenthunter.persistence.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nicolasrabier.investmenthunter.persistence.model.Property;

public interface PropertyRepository extends CrudRepository<Property, Long> {
	
	List<Property> findByPrice(BigDecimal price);
	
}
