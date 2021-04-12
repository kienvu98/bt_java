package com.product.servcie;

import java.util.List;

import com.product.model.CategoryEntity;

public interface CategoryService {
	void add(CategoryEntity categoryEntity);

	List<CategoryEntity> list();

	CategoryEntity categoryEntity(int id);

	boolean delete(int id);
}
