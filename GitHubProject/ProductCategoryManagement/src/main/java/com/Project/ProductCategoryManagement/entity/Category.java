package com.Project.ProductCategoryManagement.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="Categories")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryId;

	@NotBlank(message="Category is required")
	private String categoryName;

	private String description;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)	//cascade: to save both tables (prt to child)
	@JsonIgnore
	private List<Product> productList;
	


	public Category() {
	}

	public Category(Long categoryId, @NotBlank(message = "Category is required") String categoryName,
			String description, List<Product> productList) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.description = description;
		this.productList = productList;
	}

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




// @NotBlank: no empty space,srting;
