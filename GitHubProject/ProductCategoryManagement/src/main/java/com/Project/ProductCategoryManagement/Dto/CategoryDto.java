package com.Project.ProductCategoryManagement.Dto;

import java.util.List;

import com.Project.ProductCategoryManagement.entity.Product;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {

	private Long categoryId;

	@NotBlank(message="Category is required")
	private String categoryName;

	private String description;

	private List<Product> productList;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}



}
