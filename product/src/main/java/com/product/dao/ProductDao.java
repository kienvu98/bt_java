package com.product.dao;

import java.util.List;

import com.product.model.ProductEntity;

public interface ProductDao {
	void add(ProductEntity productEntity);

	List<ProductEntity> list();

}
