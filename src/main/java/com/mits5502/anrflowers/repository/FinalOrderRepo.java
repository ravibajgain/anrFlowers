package com.mits5502.anrflowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.FinalOrder;

public interface FinalOrderRepo extends JpaRepository<FinalOrder, Long> {

	FinalOrder findByUserId(Long userId);

}
