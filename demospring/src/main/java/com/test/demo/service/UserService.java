package com.test.demo.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.test.dao.UserDao;
import com.test.dao.UserDaoImpl;
import com.test.model.User;

@Component
public class UserService {
	UserDao userDao= new UserDaoImpl();
	public void add(User user) {
		userDao.add(user);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public User search(int id) {
		User user= userDao.search(id);
		return user;
	}
	
	public ArrayList<User> list(){
		ArrayList<User> list= userDao.list();
		return list;
	}
	
	
}
