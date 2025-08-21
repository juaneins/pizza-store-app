package com.delivery.web.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.persistence.entity.Pizza;
import com.delivery.service.PizzaService;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
	private final PizzaService pizzaService;

	public PizzaController(PizzaService pizzaService) {
		super();
		this.pizzaService = pizzaService;
	}
	
	@GetMapping
	public ResponseEntity<Page<Pizza>> getAll(
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "8") int elements) {
		return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
	}
	
	@GetMapping("/available")
	public ResponseEntity<Page<Pizza>> getAvailable(
			@RequestParam(defaultValue = "0") int page, 
			@RequestParam(defaultValue = "8") int elements,
			@RequestParam(defaultValue = "price") String sortBy,
			@RequestParam(defaultValue = "ASC") String sortDirection
			) {
				return ResponseEntity.ok(this.pizzaService.getAvailable(page, elements, sortBy, sortDirection));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Pizza> getByName(@PathVariable String name) {
		return ResponseEntity.ok(this.pizzaService.getByName(name));
	}
	
	@GetMapping("/with/{ingredient}")
	public ResponseEntity<List<Pizza>> getWith(@PathVariable String ingredient) {
		return ResponseEntity.ok(this.pizzaService.getWith(ingredient));
	}
	
	@GetMapping("/without/{ingredient}")
	public ResponseEntity<List<Pizza>> getWithout(@PathVariable String ingredient) {
		return ResponseEntity.ok(this.pizzaService.getWithout(ingredient));
	}
	
	@GetMapping("/cheapest/{price}")
	public ResponseEntity<List<Pizza>> getWithout(@PathVariable double price) {
		return ResponseEntity.ok(this.pizzaService.getCheapest(price));
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
