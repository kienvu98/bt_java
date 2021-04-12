package com.product.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.model.CategoryEntity;

@Repository
@Transactional()
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	EntityManager entityManager;
	

	@Override
	public void add(CategoryEntity categoryEntity) {

		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		session.save(categoryEntity);
	}

	@Override
	public List<CategoryEntity> list() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		List<CategoryEntity> list = session.createQuery("from CategoryEntity", CategoryEntity.class).getResultList();
		return list;
	}

	@Override
	public CategoryEntity categoryEntity(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		CategoryEntity categoryEntity = session.find(CategoryEntity.class, id);
		return categoryEntity;
	}

	/*@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		// System.out.println(session);
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			String hql = "DELETE FROM CategoryEntity WHERE categoryId=: Category_id";
			Query query = session.createQuery(hql);
			query.setParameter("Category_id", id);
			int result = query.executeUpdate();
			System.out.println("đã xóa " + result);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}*/

	public static void main(String args[]) {
		CategoryDao categoryDao = new CategoryDaoImpl();
		categoryDao.delete(13);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		//CategoryDao categoryDao= new CategoryDaoImpl();
		CategoryEntity categoryEntity= categoryEntity(id);
		System.out.println(categoryEntity);
		if(categoryEntity!=null) {
			Session session= entityManager.unwrap(Session.class);
			session.delete(categoryEntity);
			return true;
		}
		return false;
	}

}
