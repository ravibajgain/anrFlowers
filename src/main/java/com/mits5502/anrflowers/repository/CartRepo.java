package com.mits5502.anrflowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
