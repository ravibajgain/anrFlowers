package com.mits5502.anrflowers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mits5502.anrflowers.model.ProductCategory;
import com.mits5502.anrflowers.repository.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public void addCategory(ProductCategory category) {
		categoryRepo.save(category);
	}

	public List<ProductCategory> getAll() {
		return categoryRepo.findAll();
	}

}
