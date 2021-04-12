package com.product.servcie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.dao.ProductDao;
import com.product.model.ProductEntity;

@Component
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public void add(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		productDao.add(productEntity);
	}

	@Override
	public List<ProductEntity> list() {
		// TODO Auto-generated method stub
		List<ProductEntity> list= productDao.list();
		return list;
	}

}
