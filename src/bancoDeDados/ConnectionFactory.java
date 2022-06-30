package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException{
		String url="jdbc:mysql://localhost/av2db";
		String user = "root";
		String password = "1234";
		return DriverManager.getConnection(url, user, password);

	}
}
