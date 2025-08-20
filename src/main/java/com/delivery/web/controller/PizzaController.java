package com.delivery.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.persistence.entity.Pizza;
import com.delivery.service.PizzaService;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
	private final PizzaService pizzaService;

	@Autowired
	public PizzaController(PizzaService pizzaService) {
		super();
		this.pizzaService = pizzaService;
	}
	
	@GetMapping
	public ResponseEntity<List<Pizza>> getAll() {
		return ResponseEntity.ok(this.pizzaService.getAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pizza> get(@PathVariable int id) {
		return ResponseEntity.ok(this.pizzaService.get(id));
	}
	
	@PostMapping
	public ResponseEntity<Pizza> add(@RequestBody Pizza pizza) {
		if(pizza.getIdPizza() == null || !this.pizzaService.existe(pizza.getIdPizza())) {
			return ResponseEntity.ok(this.pizzaService.save(pizza));			
		}
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping
	public ResponseEntity<Pizza> update(@RequestBody Pizza pizza) {
		if(pizza.getIdPizza() != null && this.pizzaService.existe(pizza.getIdPizza())) {
			return ResponseEntity.ok(this.pizzaService.save(pizza));			
		}
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id) {
		if (this.pizzaService.existe(id)) {
			this.pizzaService.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	
	
}
