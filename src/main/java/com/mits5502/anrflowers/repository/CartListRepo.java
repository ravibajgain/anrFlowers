package com.mits5502.anrflowers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.CartList;

public interface CartListRepo extends JpaRepository<CartList, Long> {

	// @Query("FROM CartList WHERE cartId= :cartId")
	List<CartList> findAllByCartId(Long cartId);

	// @Query("FROM CartList WHERE cartId=:cartId AND productId=:productId")
	CartList findByCartProductProductIdAndCartId(Long productId, Long cartId);

}
