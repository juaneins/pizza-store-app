package com.delivery.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.delivery.persistence.entity.Pizza;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {
	
	public List<Pizza> findAllByAvailableTrueOrderByPrice();
	
	Optional<Pizza> findFirstByAvailableTrueAndNameIgnoreCase(String name);
	
	public List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
	
	public List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
	
	List<Pizza> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
	
	int countByVeganTrue();
}
