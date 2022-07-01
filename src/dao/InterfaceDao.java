package dao;

import java.sql.SQLException;
import java.util.List;
import model.Aluno;

public interface InterfaceDao {
	
	public void adicionar() throws SQLException;
	
	public List<Aluno> listar() throws SQLException;
	
	public void ListarPelaLetra(Aluno aluno, String letras);
	
	public void deletar(int id);
	
	public void alterar(int id, String s);
}
