package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.demo.connectmysql.ConnectionMysql;
import com.test.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionMysql.getJDBCConnection();
		final String sql = "insert into user(id_user, name, age) values(?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setInt(3, user.getAge());

			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionMysql.getJDBCConnection();
		final String sql = "delete from user where id_user=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public User search(int idSearch) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionMysql.getJDBCConnection();
		final String sql = "select * from user where id_user=?";

		try {
			User user = new User();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idSearch);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id_user");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				user.setId(id);
				user.setName(name);
				user.setAge(age);
			}
			return user;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

	/*
	 * public static void main(String args[]) { UserDaoImpl user = new
	 * UserDaoImpl(); User newUser = new User(3, "Long", 21); // user.add(newUser);
	 * //User t = user.search(3); //System.out.println(t.getName()); user.delete(3);
	 * }
	 */

	@Override
	public ArrayList<User> list() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionMysql.getJDBCConnection();

		final String sql = "select * from user";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList<User> list = new ArrayList<User>();
			while (rs.next()) {
				int id = rs.getInt("id_user");
				String name = rs.getString("name");
				int age = rs.getInt("age");

				User user = new User(id,name,age);
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}

}
