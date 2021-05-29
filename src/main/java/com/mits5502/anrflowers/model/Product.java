package com.mits5502.anrflowers.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "product_details")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long productId;

	@Column(name = "product_title")
	private String productTitle;

	@Column(name = "product_desc", columnDefinition = "text")
	private String productDesc;

	@Column(name = "product_qty")
	private double productQty;

	@Column(name = "product_listing_price")
	private double productListingPrice;

	@Column(name = "product_status")
	private String productStatus;

	@Column(name = "product_isactive")
	private boolean productIsActive;

	@Column(name = "vendor_username")
	private String vendorUsername;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "product_code")
	private String productCode;

	@Transient
	private MultipartFile productImage;

	public Product() {

		this.productCode = "ANRPRD-" + UUID.randomUUID().toString().substring(0, 10);

	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public double getProductQty() {
		return productQty;
	}

	public void setProductQty(double productQty) {
		this.productQty = productQty;
	}

	public double getProductListingPrice() {
		return productListingPrice;
	}

	public void setProductListingPrice(double productListingPrice) {
		this.productListingPrice = productListingPrice;
	}

	public String getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	public boolean isProductIsActive() {
		return productIsActive;
	}

	public void setProductIsActive(boolean productIsActive) {
		this.productIsActive = productIsActive;
	}

	public String getVendorUsername() {
		return vendorUsername;
	}

	public void setVendorUsername(String vendorUsername) {
		this.vendorUsername = vendorUsername;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

}