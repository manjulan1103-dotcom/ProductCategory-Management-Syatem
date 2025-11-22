package com.Project.ProductCategoryManagement.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.Project.ProductCategoryManagement.service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	CategoryService service;

	/*
	 * @PostMapping("/createCategory") public CategoryDto create(@RequestBody @Valid
	 * CategoryDto dto) { return service.create(dto); }
	 */

	@PostMapping("/createCategory") 	// to get exception or error msg in postman
	public ResponseEntity<CategoryDto> create(@RequestBody @Valid CategoryDto dto) {
		return new ResponseEntity<CategoryDto> (service.create(dto), HttpStatus.CREATED);
	}


	/*
	 * @PutMapping("/updateCategory/{id}") public CategoryDto
	 * update(@RequestBody @Valid CategoryDto dto, @PathVariable Long id) {
	 * System.out.println(id); return service.update(dto, id); }
	 */

	@PutMapping("/updateCategory/{id}") 
	public ResponseEntity<CategoryDto> update(@RequestBody @Valid CategoryDto dto, @PathVariable Long id)
	{ System.out.println(id); 
	return new ResponseEntity<CategoryDto> (service.update(dto, id), HttpStatus.OK); }


	/*
	 * public deleteById(@PathVariable Long id) {
	 *  return service.delete(id); }
	 */

	@DeleteMapping("delete/{id}")
	public ResponseEntity deleteById(@PathVariable Long id) {
		service.delete(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/deleteAllCategory")
	public String deleteAll() {
		return service.deleteAll();
	}

	@PostMapping("/saveAll")
	public List<CategoryDto> saveAll(@RequestBody List<CategoryDto> categoryList) {
		return service.saveAll(categoryList);
	}

	@GetMapping("/getAll")
	public List<CategoryDto> getAll(@RequestParam(required = false) String sortBy){
		return service.getAll(sortBy);
	}
}
