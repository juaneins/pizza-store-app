package com.delivery.service;

import org.springframework.stereotype.Service;

import com.delivery.persistence.entity.Customer;
import com.delivery.persistence.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;

	public CustomerService(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	public Customer findByPhone(String phone) {
		return this.customerRepository.findByPhoneNumber(phone);
	}
	

}
