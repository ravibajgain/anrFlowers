package com.mits5502.anrflowers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact_details")
public class ContactDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long contactId;

	@Column(name = "contact_address1")
	private String address1;

	@Column(name = "contact_address2")
	private String address2;

	@Column(name = "contact_city")
	private String city;

	@Column(name = "contact_state")
	private String state;

	@Column(name = "contact_postalcode")
	private String postalCode;

	@Column(name = "contact_country")
	private String country;

	@Column(name = "contact_phone")
	private Long phoneNo;

	@Column(name = "contact_user_id")
	private Long userContactId;

	public Long getUserContactId() {
		return userContactId;
	}

	public void setUserContactId(Long userContactId) {
		this.userContactId = userContactId;
	}

	public ContactDetails() {

	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

}
