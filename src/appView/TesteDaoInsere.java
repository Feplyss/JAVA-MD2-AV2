package appView;

import java.sql.SQLException;
import dao.AlunoDao;
import model.Aluno;

public class TesteDaoInsere {
	public static void main(String[] args) {
		Aluno aluno = new Aluno();
		aluno.setId(100);
		aluno.setNome("Maria Schnaidder");
		aluno.setEmail("maria97@gmail.com");
		aluno.setCpf("12345678901");
		aluno.setDataDeNascimento("19970328");//aaaa/m/d
		aluno.setNaturalidade("Rio de Janeiro");
		aluno.setEndereco("Rua Jos� Campos, 341");
		
//		aluno.setId(101);
//		aluno.setNome("Jos� Campos");
//		aluno.setEmail("josec@gmail.com");
//		aluno.setCpf("12345678902");
//		aluno.setDataDeNascimento("19980427");//aaaa/m/d
//		aluno.setNaturalidade("Esp�rito Santo");
//		aluno.setEndereco("Rua Independ�ncia, 185");
		
		try {
			AlunoDao dao = new AlunoDao();
			dao.adicionar(aluno);
			System.out.println("Inser��o realizada com �xito!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
