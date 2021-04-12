package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.CategoryEntity;
import com.product.servcie.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryServiceImpl categoryServiceImpl;

	@PostMapping("/add")
	CategoryEntity add(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name, @RequestParam(name = "ngay_thang") String date) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCategoryId(id);
		categoryEntity.setCategoryName(name);
		categoryEntity.setDate(date);
		categoryServiceImpl.add(categoryEntity);
		return categoryEntity;
	}

	@GetMapping("/list")
	List<CategoryEntity> list() {
		List<CategoryEntity> list = categoryServiceImpl.list();
		return list;
	}

	@GetMapping("/search/{id}")
	CategoryEntity search(@PathVariable int id) {
		CategoryEntity categoryEntity = categoryServiceImpl.categoryEntity(id);
		return categoryEntity;
	}
	
	@DeleteMapping("/delete/{id}")
	boolean delete(@PathVariable int id) {
		return categoryServiceImpl.delete(id);
	}
}
