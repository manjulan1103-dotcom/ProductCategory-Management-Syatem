package com.Project.ProductCategoryManagement.Dto;

import com.Project.ProductCategoryManagement.entity.Category;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class ProductDto {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@NotBlank(message="Product name is required")
	private String prodjuctName;

	private String description;

	@Min(value =0, message="min price should be >=0 ")
	private Double price;

	@Min(value =0, message="min price should be >=0 ")
	private Long quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="category_id")
	private Category category;
	
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProdjuctName() {
		return prodjuctName;
	}

	public void setProdjuctName(String prodjuctName) {
		this.prodjuctName = prodjuctName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
