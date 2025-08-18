package com.delivery.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
}
