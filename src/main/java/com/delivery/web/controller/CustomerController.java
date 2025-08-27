package com.delivery.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.persistence.entity.Customer;
import com.delivery.persistence.entity.Order;
import com.delivery.service.CustomerService;
import com.delivery.service.OrderService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	private final OrderService orderService;

	public CustomerController(CustomerService customerService, OrderService orderService) {
		super();
		this.customerService = customerService;
		this.orderService = orderService;
	}
	
	@GetMapping("/phone/{phone}")
	public ResponseEntity<Customer> getByPhone(@PathVariable String phone) {
		return ResponseEntity.ok(customerService.findByPhone(phone));
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Order>> getCustomerOrders(@PathVariable String id) {
		return ResponseEntity.ok(this.orderService.getCustomerOrders(id));
	}

}
