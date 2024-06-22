package database;

import java.sql.Connection;

public class test {
public static void main(String[] args) {
	Connection connection = JDBCUtill.getConnection();
	System.out.println(connection);
	JDBCUtill.closeConnection(connection);
	System.out.println(connection);
}

}
