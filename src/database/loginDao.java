//package database;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class loginDao {
//public void saveLogin(String tenDangNhap , String matKhau) {
//	Connection connection = null;
//	PreparedStatement statement = null;
//	try {
//		
//		connection = JDBCUtill.getConnection();
//		
//		String sql =  "INSERT INTO taikhoan (tenDangNhap, matKhau) VALUES (?, ?)";
//		statement = connection.prepareStatement(sql);
//		statement.setString(1, tenDangNhap);
//		statement.setString(2, matKhau);
//		
//		statement.executeUpdate();
//		
//	} catch (Exception e) {
//		e.printStackTrace();
//	}finally {
//		if(statement!=null) {
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		JDBCUtill.closeConnection(connection);
//	}
//}
//}
