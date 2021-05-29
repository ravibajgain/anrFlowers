package com.mits5502.anrflowers.service;

import java.util.List;

import com.mits5502.anrflowers.model.Product;

public interface ProductService {

	void saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Long productId);

	Product getProductById(Long id);

	List<Product> getAllActiveProducts();

	List<Product> getAllProducts();

	List<Product> getAllByLoggedInUser(String vendorUsername);

	List<Product> getProductsBySearchQuery(String query);

	List<Product> getProductsByCategory(String productCategory);

	List<Product> findAllByVendorUsernameAndIsActive(String vendorUsername, boolean isActive);

}
