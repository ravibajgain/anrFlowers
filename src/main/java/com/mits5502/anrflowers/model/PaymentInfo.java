package com.mits5502.anrflowers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment_info")
public class PaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long paymentId;

	@Column(name = "payment_card")
	private String paymentCardType;

	@Column(name = "payment_cardno")
	private String paymentCardNo;

	@Column(name = "payment_cardexmp")
	private String paymentCardExMo;

	@Column(name = "payment_cardexyr")
	private String paymentCardExYr;

	@Column(name = "payment_cardcvc")
	private String paymentCardCvc;

	@Column(name = "payment_user_id")
	private Long paymentUserId;

	public Long getPaymentId() {
		return paymentId;
	}

	public Long getPaymentUserId() {
		return paymentUserId;
	}

	public void setPaymentUserId(Long paymentUserId) {
		this.paymentUserId = paymentUserId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentCardType() {
		return paymentCardType;
	}

	public void setPaymentCardType(String paymentCardType) {
		this.paymentCardType = paymentCardType;
	}

	public String getPaymentCardNo() {
		return paymentCardNo;
	}

	public void setPaymentCardNo(String paymentCardNo) {
		this.paymentCardNo = paymentCardNo;
	}

	public String getPaymentCardExMo() {
		return paymentCardExMo;
	}

	public void setPaymentCardExMo(String paymentCardExMo) {
		this.paymentCardExMo = paymentCardExMo;
	}

	public String getPaymentCardExYr() {
		return paymentCardExYr;
	}

	public void setPaymentCardExYr(String paymentCardExYr) {
		this.paymentCardExYr = paymentCardExYr;
	}

	public String getPaymentCardCvc() {
		return paymentCardCvc;
	}

	public void setPaymentCardCvc(String paymentCardCvc) {
		this.paymentCardCvc = paymentCardCvc;
	}

}
