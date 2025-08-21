package com.delivery.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.persistence.entity.Order;
import com.delivery.persistence.projection.OrderSummary;
import com.delivery.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}	
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll() {
		return ResponseEntity.ok(this.orderService.getAll());
	}
	
	@GetMapping("/today")
	public ResponseEntity<List<Order>> getTodayOrders() {
		return ResponseEntity.ok(this.orderService.getTodayOrders());
	}
	
	@GetMapping("/outside")
	public ResponseEntity<List<Order>> getOutsideOrders() {
		return ResponseEntity.ok(this.orderService.getOutSideOrders());
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable String id) {
		return ResponseEntity.ok(this.orderService.getCustomerOrders(id));
	}
	
	@GetMapping("/summary/{orderId}")
	public ResponseEntity<OrderSummary> getSummary(@PathVariable int orderId) {
		return ResponseEntity.ok(this.orderService.getSummary(orderId));
	}
	
}
