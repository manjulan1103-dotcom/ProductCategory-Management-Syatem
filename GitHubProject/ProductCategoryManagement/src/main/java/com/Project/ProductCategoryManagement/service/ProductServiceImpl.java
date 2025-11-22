package com.Project.ProductCategoryManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.Project.ProductCategoryManagement.Dto.ProductDto;
import com.Project.ProductCategoryManagement.entity.Category;
import com.Project.ProductCategoryManagement.entity.Product;
import com.Project.ProductCategoryManagement.repository.CategoryRepository;
import com.Project.ProductCategoryManagement.repository.ProductRepository;

import jakarta.validation.Valid;


@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	CategoryRepository categoryRepo;

	@Autowired
	ProductRepository productRepo;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public ProductDto create(ProductDto dto,Long categoryId) {

		Category category = categoryRepo.findById(categoryId)
				.orElseThrow(()-> new RuntimeException("Product doesn't exists"));
		Product product = modelMapper.map(dto, Product.class);
		product.setCategory(category);
		Product savedProduct = productRepo.save(product);
		ProductDto retProduct = modelMapper.map(savedProduct, ProductDto.class);
		return retProduct;
	}

	@Override
	public ProductDto update(@Valid ProductDto dto, Long id) {
		System.out.println(id);
		Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product doesn't exist"));
		product.setProdjuctName(dto.getProdjuctName());
		product.setDescription(dto.getDescription());

		Product savedProduct =  productRepo.save(product);
		return modelMapper.map(savedProduct, ProductDto.class);
	}

	@Override
	public String delete(Long id) {
		Product p = productRepo.findById(id).orElseThrow(() -> new RuntimeException("ID doesn't Exist"));
		productRepo.delete(p);
		return "Product deleted Successfully";		
	}

	@Override
	public List<ProductDto> getAll(String sortBy) {

		String sortingParameter =(sortBy != null && !sortBy.isBlank())? sortBy:"ProductId";

		List<Product> sortedProduct =productRepo.findAll(Sort.by(sortingParameter).ascending());
		return sortedProduct
				.stream()
				.map((product) ->modelMapper.map(product,ProductDto.class))
				.collect(Collectors.toList());

	}

	@Override
	public ProductDto getById(Long id) {

		Product product = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Id doesn't exist"));

		ProductDto dto=new ProductDto();
		dto.setProductId(product.getProductId());
		dto.setProdjuctName(product.getProdjuctName());
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		dto.setQuantity(product.getQuantity());
		dto.setCategory(product.getCategory());

		return dto;
	}













}
