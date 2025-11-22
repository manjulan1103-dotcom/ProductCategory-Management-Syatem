package com.Project.ProductCategoryManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Project.ProductCategoryManagement.Dto.CategoryDto;
import com.Project.ProductCategoryManagement.entity.Category;
import com.Project.ProductCategoryManagement.repository.CategoryRepository;
import com.Project.ProductCategoryManagement.service.Exception.EmptyListException;
import com.Project.ProductCategoryManagement.service.Exception.ResoureNotFoundException;

import jakarta.validation.Valid;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository repo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public CategoryDto create(@Valid CategoryDto dto) {
		Category category = modelMapper.map(dto, Category.class);

		Category savedCategory = repo.save(category);

		CategoryDto retCategory = modelMapper.map(savedCategory, CategoryDto.class);
		return retCategory;
	}

	@Override
	public CategoryDto update(CategoryDto dto, Long id) {
		System.out.println(id);

		//		Category category = repo.findById(id)
		//				.orElseThrow(() -> new RuntimeException("Category doesn't exist"));


		//EXCEPTION HANDLING
		Category category = repo.findById(id)
				.orElseThrow(() -> new ResoureNotFoundException("Category doesn't exist"));

		category.setCategoryName(dto.getCategoryName());
		category.setDescription(dto.getDescription());

		Category savedCategory = repo.save(category);

		return modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public String delete(Long id) {
		Category c = repo.findById(id)
				.orElseThrow(() -> new ResoureNotFoundException("Id doesn't exist"));

		repo.delete(c);
		return " Category deleted successfully";	

	}

	@Override
	public String deleteAll() {
		repo.deleteAll();
		return "All categories are deleted";
	}

	@Override
	public List<CategoryDto> saveAll(List<CategoryDto> categoryList) {
//		if(categoryList.isEmpty()) {
//			throw new RuntimeException("List is Empty");
//		}
		
		//EXCEPTION HANDLING
		if(categoryList.isEmpty()) {
			throw new EmptyListException("List is Empty");
		}
		
		
		List<Category> entityList =
				categoryList
				.stream()
				.map((category) ->
				modelMapper.map(category, Category.class))
				.collect(Collectors.toList());

		List<Category> savedCategory = repo.saveAll(entityList);

		return savedCategory 
				.stream()
				.map((category) -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<CategoryDto> getAll(String sortBy) {
		String sortingParameter =
				(sortBy !=null && !sortBy.isBlank()) ? sortBy : "categoyId";

		List<Category> sortedCategory = 
				repo.findAll(Sort.by(sortingParameter).ascending());

		return sortedCategory 
				.stream()
				.map((category) -> modelMapper.map(category, CategoryDto.class))
				.collect(Collectors.toList());
	}

}	