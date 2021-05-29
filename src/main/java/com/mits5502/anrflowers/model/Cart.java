
package com.mits5502.anrflowers.model;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartId;

	@Column(name = "grand_total")
	private double grandTotal;

	@Column(name = "cart_list")
	private int cartList;

	@OneToOne
	private User user;

	public Cart() {

	}

	public Long getCartId() {
		return cartId;
	}

	public Cart setCartId(Long cartId) {
		this.cartId = cartId;
		return this;
	}

	public double getGrandTotal() {
		return grandTotal;
	}

	public Cart setGrandTotal(double grandTotal) {
		DecimalFormat dc = new DecimalFormat("#.##");
		this.grandTotal = Double.valueOf(dc.format(grandTotal));
		return this;
	}

	public int getCartList() {
		return cartList;
	}

	public Cart setCartList(int cartList) {
		this.cartList = cartList;
		return this;
	}

	public User getUser() {
		return user;
	}

	public Cart setUser(User user) {
		this.user = user;
		return this;
	}

}
