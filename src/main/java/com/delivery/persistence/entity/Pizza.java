package com.delivery.persistence.entity;

import java.io.Serializable;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.delivery.persistence.audit.AuditPizzaListener;
import com.delivery.persistence.audit.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza")
@EntityListeners({ AuditingEntityListener.class, AuditPizzaListener.class })
public class Pizza extends AuditableEntity implements Serializable {

	private static final long serialVersionUID = 6709703717119801007L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pizza", nullable = false)
	private Integer idPizza;

	@Column(nullable = false, length = 30, unique = true)
	private String name;

	@Column(nullable = false, length = 150)
	private String description;

	@Column(nullable = false, columnDefinition = "Decimal(5,2)")
	private Double price;

	@Column(columnDefinition = "TINYINT")
	private boolean vegetarian;

	@Column(columnDefinition = "TINYINT")
	private boolean vegan;

	@Column(columnDefinition = "TINYINT", nullable = false)
	private boolean available;

	public Pizza() {
		// empty constructor
	}

	public Integer getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Integer idPizza) {
		this.idPizza = idPizza;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Pizza [idPizza=" + idPizza + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", vegetarian=" + vegetarian + ", vegan=" + vegan + ", available=" + available + "]";
	}
}
