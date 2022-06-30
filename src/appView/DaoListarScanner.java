package appView;

import java.sql.SQLException;
import dao.AlunoDao;

public class DaoListarScanner {
	public static void main(String[] args) {		
		try {
			AlunoDao dao = new AlunoDao();
			dao.listarPelaLetra();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
