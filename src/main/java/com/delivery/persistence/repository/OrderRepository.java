package com.delivery.persistence.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.delivery.persistence.entity.Order;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {

}
