package com.delivery.persistence.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.delivery.persistence.entity.Pizza;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {
	
	public List<Pizza> findAllByAvailableTrueOrderByPrice();
	
	Pizza findAllByAvailableTrueAndNameIgnoreCase(String name);
}
