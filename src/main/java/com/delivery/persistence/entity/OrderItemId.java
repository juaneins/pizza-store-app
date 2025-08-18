package com.delivery.persistence.entity;

import java.util.Objects;

public class OrderItemId {

	private Integer idOrder;
	private Integer idItem;

	public OrderItemId() {

	}

	public OrderItemId(Integer idOrder, Integer idItem) {
		super();
		this.idOrder = idOrder;
		this.idItem = idItem;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idItem, idOrder);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemId other = (OrderItemId) obj;
		return Objects.equals(idItem, other.idItem) && Objects.equals(idOrder, other.idOrder);
	}

}
