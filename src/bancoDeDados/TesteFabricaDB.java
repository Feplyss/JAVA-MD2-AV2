package bancoDeDados;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteFabricaDB {
	public static void main(String[] args) {
		try {
			Connection con = ConnectionFactory.getConnection();
			System.out.println("Ok, conectado ao banco de dados");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
