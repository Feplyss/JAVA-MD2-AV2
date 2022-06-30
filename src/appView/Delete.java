package appView;

import java.sql.SQLException;

import dao.AlunoDao;

public class Delete {

	public static void main(String[] args) {
		
		AlunoDao dao;
		try {
			dao = new AlunoDao();
			dao.alterar("101");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
