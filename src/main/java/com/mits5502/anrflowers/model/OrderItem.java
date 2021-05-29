
package com.mits5502.anrflowers.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderItemId;

	@OneToOne
	private Product product;

	@Column(name = "order_user_id")
	private Long userId;

	@Column(name = "product_unit_price")
	private double productPrice;

	@Column(name = "order_qty")
	private int productOrderQty;

	@Column(name = "order_total")
	private double orderTotal;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	private Date date;

	@Column(name = "order_status")
	private String orderStatus;

	public OrderItem() {

	}

	public Long getOrderItemId() {
		return orderItemId;
	}

	public OrderItem setOrderItemId(Long orderItemId) {
		this.orderItemId = orderItemId;
		return this;
	}

	public Product getProduct() {
		return product;
	}

	public OrderItem setProduct(Product product) {
		this.product = product;
		return this;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public OrderItem setProductPrice(double productPrice) {
		this.productPrice = productPrice;
		return this;
	}

	public int getProductOrderQty() {
		return productOrderQty;
	}

	public OrderItem setProductOrderQty(int productOrderQty) {
		this.productOrderQty = productOrderQty;
		return this;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public OrderItem setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
		return this;
	}

	public Long getUserId() {
		return userId;
	}

	public OrderItem setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public Date getDate() {
		return date;
	}

	public OrderItem setDate(Date date) {
		this.date = date;
		return this;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public OrderItem setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
		return this;
	}

}
