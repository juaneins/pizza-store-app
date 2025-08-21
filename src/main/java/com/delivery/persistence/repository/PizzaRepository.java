package com.delivery.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.delivery.persistence.entity.Pizza;
import com.delivery.service.dto.UpdatePizzaPriceDto;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {
	
	public List<Pizza> findAllByAvailableTrueOrderByPrice();
	
	Optional<Pizza> findFirstByAvailableTrueAndNameIgnoreCase(String name);
	
	public List<Pizza> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
	
	public List<Pizza> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String description);
	
	List<Pizza> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(double price);
	
	int countByVeganTrue();
	
	@Query(value ="update pizza "
			+ "set price = :#{#newPizzaPrice.newPrice} "
			+ "where id_pizza = :#{#newPizzaPrice.pizzaId}", nativeQuery = true)
	@Modifying
	void updatePrice(@Param(value = "newPizzaPrice") UpdatePizzaPriceDto newPizzaPrice);
	
	
}
