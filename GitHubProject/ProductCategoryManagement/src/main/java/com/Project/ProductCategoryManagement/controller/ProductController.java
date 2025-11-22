package com.Project.ProductCategoryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.ProductCategoryManagement.Dto.CategoryDto;
import com.Project.ProductCategoryManagement.Dto.ProductDto;
import com.Project.ProductCategoryManagement.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	public ProductService service;

	@PostMapping("/create/{categoryId}")
	public ProductDto create( @Valid @RequestBody ProductDto dto,
			@PathVariable Long categoryId) {
		return service.create(dto,categoryId);
	}
	
	@PutMapping("update/{id}")
	public ProductDto update(@RequestBody @Valid ProductDto dto, @PathVariable Long id ) {
		System.out.println(id);
		return service.update(dto, id );
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteById(@PathVariable Long id) {
		return service.delete(id);
	}
	
	@GetMapping("/getAll")
	public List<ProductDto> getAll(@RequestParam(required = false) String sortBy){
		return service.getAll(sortBy);
	}
	
	@GetMapping("/getById/{id}")
	public ProductDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
	
}
