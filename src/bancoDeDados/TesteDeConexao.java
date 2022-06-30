package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteDeConexao {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost";
		String user = "root";
		String password = "1234";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Conecao executada com sucesso!");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
