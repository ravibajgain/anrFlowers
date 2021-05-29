package com.mits5502.anrflowers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mits5502.anrflowers.model.ProductCategory;

public interface CategoryRepo extends JpaRepository<ProductCategory, Long> {

}
