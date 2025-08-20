package com.delivery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.delivery.persistence.entity.Order;
import com.delivery.persistence.repository.OrderRepository;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	private static final String DELIVERY = "D";
	private static final String CARRYOUT = "C";
	private static final String ON_SITE = "S";

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	public List<Order> getAll() {
		return this.orderRepository.findAll();
	}

	public List<Order> getTodayOrders() {
		LocalDateTime today = LocalDate.now().atTime(0, 0);
		return this.orderRepository.findAllByDateAfter(today);

	}

	public List<Order> getOutSideOrders() {
		List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
		return this.orderRepository.findAllByMethodIn(methods);
	}

}
