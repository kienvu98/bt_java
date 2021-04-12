package com.product.servcie;

import java.util.List;

import com.product.model.ProductEntity;

public interface ProductService {
	void add(ProductEntity productEntity);

	List<ProductEntity> list();
}
