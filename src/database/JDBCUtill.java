package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtill {
public static Connection getConnection() {
	Connection c = null;
	
	// dang ki driver 
	try {
		DriverManager.registerDriver(new Driver());
		String url = "jdbc:mysql://localhost:3366/lichsutinnhan";
		String username = "root";
		String password = "";
		
		
		// tao ket noi 
		c = DriverManager.getConnection(url, username, password);
		System.out.println("Ket noi thanh cog ");
	} catch (SQLException e) {
		System.out.println("Ket noi that bai");
		e.printStackTrace();
	}
	
	
	return c;
}
public static void closeConnection(Connection c) {
	try {
		if(c!= null) {
			c.close();
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
