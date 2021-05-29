package com.mits5502.anrflowers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mits5502.anrflowers.model.Product;
import com.mits5502.anrflowers.service.ProductService;

@Controller
public class NavigationController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		List<Product> products = productService.getAllActiveProducts();
		model.addAttribute("products", products);

		return "home";

	}

	@GetMapping(value = "logout")
	public String logoutView() {
		return "home";

	}

	@GetMapping(value = "error")
	public String errorView() {
		return "errorpage";

	}

	@GetMapping(value = "search")
	public String searchProducts(@RequestParam("query") String query, Model model) {

		model.addAttribute("search", productService.getProductsBySearchQuery(query));
		return "search";
	}

	@GetMapping(value = "category")
	public String viewByCategory(@RequestParam(name = "c") String category, Model model) {
		System.out.println("=======" + category);
		List<Product> products = productService.getProductsByCategory(category);
		products.forEach(product -> {
			System.out.println(category + "================" + product.getProductTitle());
		});
		model.addAttribute("productsByCategory", productService.getProductsByCategory(category));
		return "bycategory";

	}

}
