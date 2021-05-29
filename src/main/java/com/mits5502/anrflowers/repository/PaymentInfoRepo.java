package com.mits5502.anrflowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.PaymentInfo;

public interface PaymentInfoRepo extends JpaRepository<PaymentInfo, Long> {

	PaymentInfo findByPaymentUserId(Long paymentUserId);

}
