package com.delivery.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
public class OrderItem {

	@Id
	@Column(name = "id_order", nullable = false)
	private Integer idOrder;

	@Id
	@Column(name = "id_item", nullable = false)
	private Integer idItem;

	@Column(name = "id_pizza", nullable = false)
	private Integer idPizza;

	@Column(nullable = false, columnDefinition = "Decimal(2,1)")
	private Double quantity;

	@Column(nullable = false, columnDefinition = "Decimal(5,2)")
	private Double price;

	@ManyToOne
	@JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
	private Order order;

	@OneToOne
	@JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
	private Pizza pizza;

	public OrderItem() {
		super();
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Integer idPizza) {
		this.idPizza = idPizza;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}
