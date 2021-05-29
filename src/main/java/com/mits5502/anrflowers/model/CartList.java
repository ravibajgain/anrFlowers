package com.mits5502.anrflowers.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart_list")
public class CartList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartListId;

	@OneToOne
	private Product cartProduct;

	private Long cartId;

	private int cartProductQty;

	private double cartPrice;

	private double cartTotal;

	public CartList() {

	}

	public Long getCartListId() {
		return cartListId;
	}

	public void setCartListId(Long cartListId) {
		this.cartListId = cartListId;
	}

	public Product getCartProduct() {
		return cartProduct;
	}

	public void setCartProduct(Product cartProduct) {
		this.cartProduct = cartProduct;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public int getCartProductQty() {
		return cartProductQty;
	}

	public void setCartProductQty(int cartProductQty) {
		this.cartProductQty = cartProductQty;
	}

	public double getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	public double getCartTotal() {
		return cartTotal;
	}

	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}

}
