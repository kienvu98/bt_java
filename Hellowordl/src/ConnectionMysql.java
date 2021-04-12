
import java.sql.*;  

public class ConnectionMysql {
	public static Connection getJDBCConnection() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "kienvu12345");
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
