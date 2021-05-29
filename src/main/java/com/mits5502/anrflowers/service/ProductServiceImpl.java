package com.mits5502.anrflowers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mits5502.anrflowers.model.Product;
import com.mits5502.anrflowers.repository.ProductRepo;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

	@Override
	public void saveProduct(Product product) {

		productRepo.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		productRepo.save(product);
	}

	@Override
	public void deleteProduct(Long productId) {
		productRepo.deleteById(productId);
	}

	@Override
	public Product getProductById(Long id) {
		return productRepo.findById(id).get();
	}

	@Override
	public List<Product> getAllActiveProducts() {
		return (List<Product>) productRepo.findAllByProductIsActive(true);
	}

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepo.findAll();
	}

	@Override
	public List<Product> getAllByLoggedInUser(String vendorUsername) {
		return productRepo.findAllByVendorUsername(vendorUsername);
	}

	@Override
	public List<Product> getProductsBySearchQuery(String query) {
		return productRepo.searchProduct(query);
	}

	@Override
	public List<Product> getProductsByCategory(String productCategory) {
		return productRepo.findAllByproductCategory(productCategory);
	}

	@Override
	public List<Product> findAllByVendorUsernameAndIsActive(String vendorUsername, boolean isActive) {
		return productRepo.findAllByVendorUsernameAndProductIsActive(vendorUsername, isActive);
	}

}
