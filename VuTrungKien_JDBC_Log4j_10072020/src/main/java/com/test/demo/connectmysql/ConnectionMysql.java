package com.test.demo.connectmysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionMysql {
	public static Connection getJDBCConnection() {
		final String url= "jdbc:mysql://localhost:3306/demo";
		final String user="root";
		final String password="kienvu12345";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void main(String args[]) {
		Connection connection= getJDBCConnection();
		if(connection==null) {
			System.out.println("kết nối thất bại");
		}else {
			System.out.println("kết nối thành công");
		}
	}
}
