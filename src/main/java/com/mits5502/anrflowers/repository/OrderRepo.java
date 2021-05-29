package com.mits5502.anrflowers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.OrderItem;

public interface OrderRepo extends JpaRepository<OrderItem, Long> {

	List<OrderItem> findAllByUserId(Long userId);

	// List<OrderItem> finaAllByUserIdAndOrderStatus(Long userId, String
	// orderStatus);

	List<OrderItem> findAllByOrderStatusAndUserId(String orderStatus, Long userId);

}
