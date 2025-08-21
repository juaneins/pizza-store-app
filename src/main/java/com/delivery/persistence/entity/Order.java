package com.delivery.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "pizza_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order", nullable = false)
	private Integer idOrder;

	@Column(name = "id_customer", nullable = false)
	private String idCustomer;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime date;

	@Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
	private Double total;

	@Column(nullable = false, columnDefinition = "CHAR(1)")
	private String method;

	@Column(name = "additional_notes", length = 200)
	private String additionalNotes;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
	private Customer customer;

	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	@OrderBy("price asc")
	private List<OrderItem> items;

	public Order() {

	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

}
