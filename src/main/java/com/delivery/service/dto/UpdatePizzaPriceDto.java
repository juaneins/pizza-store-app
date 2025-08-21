package com.delivery.service.dto;

public class UpdatePizzaPriceDto {

	private int pizzaId;
	private double newPrice;

	public UpdatePizzaPriceDto() {

	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(double newPrice) {
		this.newPrice = newPrice;
	}

}
