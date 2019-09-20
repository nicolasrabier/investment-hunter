package com.nicolasrabier.investmenthunter.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.nicolasrabier.investmenthunter.persistence.model.WebServiceCall;

public interface WebServiceCallRepository  extends CrudRepository<WebServiceCall, Long> {

}
