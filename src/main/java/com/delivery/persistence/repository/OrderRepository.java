package com.delivery.persistence.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.delivery.persistence.entity.Order;

public interface OrderRepository extends ListCrudRepository<Order, Integer> {

	List<Order> findAllByDateAfter(LocalDateTime date);
	
	List<Order> findAllByMethodIn(List<String> methods);
	
	@Query(value="select * from pizza_order where id_customer = :id", nativeQuery = true)
	List<Order> findCustomerOrders(@Param("id") String idCustomer);
}
