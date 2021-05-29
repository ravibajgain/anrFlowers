package com.mits5502.anrflowers.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mits5502.anrflowers.model.CurrentLoggedInUser;
import com.mits5502.anrflowers.model.Product;
import com.mits5502.anrflowers.model.ProductCategory;
import com.mits5502.anrflowers.service.CategoryService;
import com.mits5502.anrflowers.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// @Autowired
	// private ProductCategoryService productCategoryService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private HttpSession session;

	@GetMapping("home")
	public String getViewProductHomeView(Model model) {

		return "producthome";
	}

	@GetMapping("viewproduct/{id}")
	public String getViewSingleProductView(@RequestParam("id") Long id, Model model) {
		Product singleProduct = productService.getProductById(id);
		model.addAttribute("product", singleProduct);
		return "v_newproduct";
	}

	@RequestMapping("create")
	public String getViewProductView(Model model) {
		model.addAttribute("category", categoryService.getAll());
		return "v_newproduct";
	}

	@PostMapping("addproduct")
	public String saveNewProductListings(@ModelAttribute Product product, HttpServletRequest req, Model model) {

		product.setVendorUsername(req.getUserPrincipal().getName());
		product.setProductIsActive(true);
		// Add File Upload Functionality
		MultipartFile file = product.getProductImage();

		try {

			// Server side location configuration
			file.transferTo(new File(req.getSession().getServletContext().getRealPath("/resources/img/pageimg/"),
					product.getProductCode() + ".jpg"));

			// D://location/eclipse-workspace/anrflowers/src/main/webapp/resources/img/pageimg

			file.transferTo(new File("C:/Users/user/Desktop/anrflowers/src/main/webapp/resources/img/pageimg/",
					product.getProductCode() + ".jpg"));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		productService.saveProduct(product);
		return "redirect:listproducts";
	}

	@GetMapping("listproducts")
	public String getAllProductListings(Model model) {
		String username = ((CurrentLoggedInUser) session.getAttribute("currentLoggedInUser")).getUserName();
		List<Product> products = productService.findAllByVendorUsernameAndIsActive(username, true);
		model.addAttribute("products", products);
		return "v_productlist";
	}

	@RequestMapping(value = "editproduct", method = RequestMethod.GET)
	public String editProductView(@RequestParam("id") Long id, Model model) {
		Product singleProduct = productService.getProductById(id);
		model.addAttribute("product", singleProduct);
		return "v_editproduct";
	}

	@PostMapping("updateproduct")
	public String updateProduct(@ModelAttribute Product product, HttpServletRequest req) {
		product.setVendorUsername(req.getUserPrincipal().getName());
		product.setProductIsActive(true);
		MultipartFile file = product.getProductImage();

		try {

			file.transferTo(new File("/Users/iamsan/eclipse-workspace/anrflowers/src/main/webapp/resources/img/pageimg",
					product.getProductCode() + ".jpg"));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		productService.updateProduct(product);

		return "redirect:listproducts";
	}

	@RequestMapping(value = "deleteproduct", method = RequestMethod.GET)
	public String deleteProductListing(@RequestParam("id") Long productId) {
		productService.deleteProduct(productId);
		return "redirect:listproducts";
	}

	@PostMapping(value = "addcategory")
	public String addProductCategory(@ModelAttribute ProductCategory productCategory) {
		categoryService.addCategory(productCategory);
		return "redirect:create";

	}

}
