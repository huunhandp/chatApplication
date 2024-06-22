package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class messageDao {
public void saveMessage(String sender , String message) {
	// giữ kết nối đến cơ sở dữ liệu
	Connection connection = null;
	// giữ câu lệnh sql để thực thi 
	PreparedStatement statement = null;
	
	try {
	  connection = JDBCUtill.getConnection();
	  
	  	  String maHoaTinNhan = maHoa.maHoa(message);

	  // chuẩn bị câu lệnh
	  String sql = "INSERT INTO messages (sender, message) VALUES (?, ?)";
	  statement = connection.prepareStatement(sql);// chuẩn bị câu lệnh sql để thực thi 
	  statement.setString(1, sender);// đặt giá trị dấu ? tham số đầu tiên trog lệnh sql là sender
	  statement.setString(2, maHoaTinNhan); // đặt giá trị dấu ? tham số thứ 2 trong lệnh sql là message
	  
	  // thực thi câu lệnh
	  statement.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(statement!=null) {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		JDBCUtill.closeConnection(connection);
	}
}
// phương thức lấy tất cả tin nhắn 
public List<String> getAllMessage(){
	List<String> messages = new ArrayList<String>();
	
	Connection connection = null;
	PreparedStatement statement = null;
	
	ResultSet resultset = null;
	
	try {
		connection = JDBCUtill.getConnection();
		String sql = "SELECT sender, message FROM messages";
		
		statement = connection.prepareStatement(sql);
		resultset = statement.executeQuery();
		
		while(resultset.next()) {
			String sender = resultset.getString("sender");
			String message = resultset.getString("message");
			
			String giaiMaTinNhan = maHoa.giaiMa(message);
			
			
			messages.add(sender+" : "+giaiMaTinNhan);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(resultset!=null) {
			try {
				resultset.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(statement!=null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		JDBCUtill.closeConnection(connection);
	}
	return messages;
}
}
