package com.delivery.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.delivery.persistence.entity.Order;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {

	List<Order> findAllByDateAfter(LocalDateTime date);
	
	List<Order> findAllByMethodIn(List<String> methods);
}
