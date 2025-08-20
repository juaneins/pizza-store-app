package com.delivery.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.delivery.persistence.entity.Order;
import com.delivery.persistence.repository.OrderRepository;

@Service
public class OrderService {
	
	private final OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}
	
	public List<Order> getAll() {
		return this.orderRepository.findAll();
	}

}
