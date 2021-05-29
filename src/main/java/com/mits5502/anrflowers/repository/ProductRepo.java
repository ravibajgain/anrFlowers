package com.mits5502.anrflowers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mits5502.anrflowers.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	List<Product> findAllByProductIsActive(boolean isActive);

	List<Product> findAllByVendorUsername(String vendorUsername);

	List<Product> findAllByVendorUsernameAndProductIsActive(String vendorUsername, boolean isActive);

	@Query("FROM Product WHERE productTitle LIKE CONCAT('%',:query,'%')")
	public List<Product> searchProduct(@Param("query") String query);

	@Query("FROM Product WHERE productCategory=:productCategory")
	List<Product> findAllByproductCategory(@Param("productCategory") String productCategory);

}
