package com.nicolasrabier.investmenthunter.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.nicolasrabier.investmenthunter.persistence.model.Configuration;

public interface ConfigurationRepository extends CrudRepository<Configuration, Long> {
	
	Configuration findById(long id);
	
}
