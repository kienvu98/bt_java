package com.product.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.model.ProductEntity;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	EntityManager entityManager;

	@Override
	public void add(ProductEntity productEntity) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Transaction transaction =session.beginTransaction();
		System.out.println(productEntity.getProductId());
		System.out.println(productEntity.getProductName());
		System.out.println(productEntity.getCategoryEntity().getCategoryId());
		session.save(productEntity);
		transaction.commit();

	}

	@Override
	public List<ProductEntity> list() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		List<ProductEntity> list = session.createQuery("from ProductEntity", ProductEntity.class).getResultList();
		return list;
	}

}
