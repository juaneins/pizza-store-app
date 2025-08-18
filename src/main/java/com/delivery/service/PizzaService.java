package com.delivery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.delivery.persistence.entity.Pizza;

@Service
public class PizzaService {
	
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PizzaService(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Pizza> getAll() {
		return jdbcTemplate.query("select * from pizza", new BeanPropertyRowMapper<Pizza>(Pizza.class));
	}
	
	
	
	

}
