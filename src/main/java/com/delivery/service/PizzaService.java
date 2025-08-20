package com.delivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.delivery.persistence.entity.Pizza;
import com.delivery.persistence.repository.PizzaRepository;

@Service
public class PizzaService {

	private PizzaRepository pizzaRepository;

	public PizzaService(PizzaRepository pizzaRepository) {
		super();
		this.pizzaRepository = pizzaRepository;
	}

	public List<Pizza> getAll() {
		return pizzaRepository.findAll();
	}
	
	public List<Pizza> getAvailable() {
		System.out.println("count:" + this.pizzaRepository.countByVeganTrue());
		return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
	}
	
	public Pizza getByName(String name) {
		return this.pizzaRepository
				.findFirstByAvailableTrueAndNameIgnoreCase(name)
				.orElseThrow(() -> new RuntimeException("la pizza no existe"));
	}
	
	public List<Pizza> getWith(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
	}
	
	public List<Pizza> getWithout(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
	}
	
	public List<Pizza> getCheapest(double price) {
		return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
	}

	public Pizza get(int id) {
		return pizzaRepository.findById(id).orElse(null);
	}
	
	public Pizza save(Pizza pizza) {
		return pizzaRepository.save(pizza);
	}
	
	public boolean existe(int id) {
		return pizzaRepository.existsById(id); 
	}
	
	public void delete(int id) {
		this.pizzaRepository.deleteById(id);
	}
	

}
