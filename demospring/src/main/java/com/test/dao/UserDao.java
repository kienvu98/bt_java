package com.test.dao;

import java.util.ArrayList;

import com.test.model.User;

public interface UserDao {
	void add(User user);

	void delete(int id);

	User search(int idSearch);

	ArrayList<User> list();

}
