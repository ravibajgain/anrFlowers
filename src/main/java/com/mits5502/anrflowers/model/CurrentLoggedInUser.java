package com.mits5502.anrflowers.model;

public class CurrentLoggedInUser {

	private Long userId;

	private String userName;

	private String firstName;

	private String lastName;

	private String email;

	private String role;

	private Cart cart;

	public CurrentLoggedInUser() {

	}

	public Long getUserId() {
		return userId;
	}

	public CurrentLoggedInUser setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public CurrentLoggedInUser setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public CurrentLoggedInUser setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public CurrentLoggedInUser setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public CurrentLoggedInUser setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getRole() {
		return role;
	}

	public CurrentLoggedInUser setRole(String role) {
		this.role = role;
		return this;
	}

	public Cart getCart() {
		return cart;
	}

	public CurrentLoggedInUser setCart(Cart cart) {
		this.cart = cart;
		return this;
	}

}
