package com.mits5502.anrflowers.model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "final_order")
public class FinalOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "contact_id")
	private Long contactId;

	@Column(name = "payment_id")
	private Long paymentId;

	@Column(name = "grand_total")
	private double grandTotal;

	@Column(name = "total_items")
	private int totalItems;

	public FinalOrder() {

	}

	public Long getOrderId() {
		return orderId;
	}

	public FinalOrder setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public FinalOrder setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Long getContactId() {
		return contactId;
	}

	public FinalOrder setContactId(Long contactId) {
		this.contactId = contactId;
		return this;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public FinalOrder setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
		return this;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public FinalOrder setGrandTotal(double grandTotal) {
		DecimalFormat dc = new DecimalFormat("#.##");
		this.grandTotal = Double.valueOf(dc.format(grandTotal));
		return this;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public FinalOrder setTotalItems(int totalItems) {
		this.totalItems = totalItems;
		return this;
	}

}
