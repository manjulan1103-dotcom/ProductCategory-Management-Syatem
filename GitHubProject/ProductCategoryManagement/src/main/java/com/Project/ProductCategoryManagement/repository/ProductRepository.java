package com.Project.ProductCategoryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Project.ProductCategoryManagement.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
