package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.CategoryEntity;
import com.product.model.ProductEntity;
import com.product.servcie.CategoryService;
import com.product.servcie.CategoryServiceImpl;
import com.product.servcie.ProductService;
import com.product.servcie.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductControlerr {

	@Autowired
	ProductServiceImpl productService;
	@Autowired
	CategoryServiceImpl categoryService;

	@PostMapping("/add")
	ProductEntity add(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name,
			@RequestParam(name = "cate_id") int cateId) {

		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(id);
		productEntity.setProductName(name);
		CategoryEntity categoryEntity = categoryService.categoryEntity(cateId);
		if (categoryEntity != null) {
			productEntity.setCategoryEntity(categoryEntity);
			productService.add(productEntity);

		}
		return productEntity;

	}

	@GetMapping("/list")
	List<ProductEntity> list() {
		List<ProductEntity> list = productService.list();
		return list;
	}

}
