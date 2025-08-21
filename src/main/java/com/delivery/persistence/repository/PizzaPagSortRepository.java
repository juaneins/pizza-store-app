package com.delivery.persistence.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import com.delivery.persistence.entity.Pizza;


public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<Pizza, Integer> {
	
	Page<Pizza> findByAvailableTrue(Pageable pageable);

}
