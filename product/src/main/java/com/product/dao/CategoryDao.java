package com.product.dao;

import java.util.List;

import com.product.model.CategoryEntity;

public interface CategoryDao {
	void add(CategoryEntity categoryEntity);

	List<CategoryEntity> list();

	CategoryEntity categoryEntity(int id);

	boolean delete(int id);
}
