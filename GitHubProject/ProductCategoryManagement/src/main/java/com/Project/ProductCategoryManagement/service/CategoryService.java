package com.Project.ProductCategoryManagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Project.ProductCategoryManagement.Dto.CategoryDto;
import jakarta.validation.Valid;


@Service
public interface CategoryService {

	CategoryDto create(@Valid CategoryDto dto);

	CategoryDto update(CategoryDto dto, Long id);

	String delete(Long id);

	String deleteAll();

	List<CategoryDto> saveAll(List<CategoryDto> categoryList);

	List<CategoryDto> getAll(String sortBy);





}
