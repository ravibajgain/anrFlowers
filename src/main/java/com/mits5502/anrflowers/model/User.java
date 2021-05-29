package com.mits5502.anrflowers.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "user_data")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
      @Column(name = "user_id")
	private Long userId;

	@NotEmpty(message = "Please enter your password")
	@Column(name = "user_password")
	private String userPassword;

	@NotEmpty(message = "Username cannot be blank, Please enter your username")
	@Column(name = "user_username")
	private String userName;

	@Column(name = "user_firstname")
	private String firstName;

	@Column(name = "user_lastname")
	private String lastName;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_role")
	private String role;

	@Column(name = "user_isEnabled")
	private boolean isEnabled;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	@Transient
	private String passwordConf;

	public User() {

	}

	public Long getUserId() {
		return userId;
	}

	public User setUserId(Long userId) {
		this.userId = userId;
		return this;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public User setUserPassword(String userPassword) {
		this.userPassword = userPassword;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getRole() {
		return role;
	}

	public User setRole(String role) {
		this.role = role;
		return this;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public User setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		return this;
	}

	public String getPasswordConf() {
		return passwordConf;
	}

	public User setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
		return this;
	}

	public Cart getCart() {
		return cart;
	}

	public User setCart(Cart cart) {
		this.cart = cart;
		return this;

	}

}
