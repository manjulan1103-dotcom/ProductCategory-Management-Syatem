package com.Project.ProductCategoryManagement.service;


import java.util.List;

import com.Project.ProductCategoryManagement.Dto.ProductDto;

import jakarta.validation.Valid;

public interface ProductService {

	ProductDto create(ProductDto dto, Long categoryId);

	ProductDto update(@Valid ProductDto dto, Long id);

	String delete(Long id);

	List<ProductDto> getAll(String sortBy);

	ProductDto getById(Long id);

}
