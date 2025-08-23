package com.delivery.persistence.audit;



import org.springframework.util.SerializationUtils;

import com.delivery.persistence.entity.Pizza;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class AuditPizzaListener {
	
	private Pizza currentValue;
	
	@PostLoad
	public void postLoad(Pizza pizza) {
		System.out.println("POST LOAD");		
		this.currentValue = SerializationUtils.clone(pizza);
	}
	
	@PostPersist
	@PostUpdate
	public void onPostPersist(Pizza pizza) {
		System.out.println("POST PERSIST OR UPDATE");
		System.out.println("OLD VALUE: " + this.currentValue.toString());
		System.out.println("NEW VALUE: " + pizza.toString());
	}
	
	@PreRemove
	public void onPreDelete(Pizza pizza) {
		System.out.println(pizza.toString());
	}

}
