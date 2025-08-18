package com.delivery.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.delivery.persistence.entity.Pizza;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {
	
	
}
