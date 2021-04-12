package com.product.servcie;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.product.dao.CategoryDao;
import com.product.model.CategoryEntity;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	@Transactional
	public void add(CategoryEntity categoryEntity) {
		// TODO Auto-generated method stub
		categoryDao.add(categoryEntity);
	}

	@Override
	public List<CategoryEntity> list() {
		// TODO Auto-generated method stub
		List<CategoryEntity> list = categoryDao.list();
		return list;
	}

	@Override
	public CategoryEntity categoryEntity(int id) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = categoryDao.categoryEntity(id);
		return categoryEntity;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return categoryDao.delete(id);
	}
	/*
	 * public static void main(String args[]) { CategoryService categoryService =
	 * new CategoryServiceImpl(); CategoryEntity categoryEntity=
	 * categoryService.categoryEntity(13);
	 * System.out.println(categoryEntity.getCategoryName()); }
	 */

}
