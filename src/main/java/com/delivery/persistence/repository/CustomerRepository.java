package com.delivery.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.delivery.persistence.entity.Customer;


public interface CustomerRepository extends ListCrudRepository<Customer, String> {
	
	@Query("select c from Customer c where c.phoneNumber = :phone")
	Customer findByPhoneNumber(@Param("phone") String phone);

}
