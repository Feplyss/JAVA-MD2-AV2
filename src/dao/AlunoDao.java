package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bancoDeDados.ConnectionFactory;
import model.Aluno;

public class AlunoDao {
	private final Connection con;
	
	public AlunoDao() throws SQLException {
		this.con = ConnectionFactory.getConnection();		
	}
	
	public List<Aluno> listar() throws SQLException{
		String sql = "SELECT * FROM aluno";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		List<Aluno> alunos = new ArrayList<Aluno>();

		System.out.println("=========================================");
		System.out.println("Lista");
		System.out.println("=========================================");
			
		while(rs.next()) {
			Aluno aluno = new Aluno();
			
			System.out.println("ID..................: "+rs.getInt(1));
			System.out.println("Nome................: "+rs.getString(2));
			System.out.println("E-mail..............: "+rs.getString(3));
			System.out.println("CPF.................: "+rs.getString(4));
			System.out.println("Nascimento..........: "+rs.getString(5));
			System.out.println("Naturalidade........: "+rs.getString(6));
			System.out.println("Endereco............: "+rs.getString(7));
			System.out.println("=========================================");

			alunos.add(aluno);
		}
		
		stmt.close();
		con.close();
		
		return alunos;
	}
	
	public List<Aluno> listarPelaLetra(String s) throws SQLException{
		String sql = "SELECT * FROM aluno WHERE nome LIKE '" + s + "'";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		List<Aluno> alunos = new ArrayList<Aluno>();

		System.out.println("=========================================");
		System.out.println("Lista");
		System.out.println("=========================================");
			
		while(rs.next()) {
			Aluno aluno = new Aluno();
			
			System.out.println("ID..................: "+rs.getInt(1));
			System.out.println("Nome................: "+rs.getString(2));
			System.out.println("E-mail..............: "+rs.getString(3));
			System.out.println("CPF.................: "+rs.getString(4));
			System.out.println("Nascimento..........: "+rs.getString(5));
			System.out.println("Naturalidade........: "+rs.getString(6));
			System.out.println("Endereco............: "+rs.getString(7));
			System.out.println("=========================================");

			alunos.add(aluno);
		}
		
		stmt.close();
		con.close();
		
		return alunos;
	}
	
	public void adicionar(Aluno aluno) throws SQLException {
		String sql;
		sql = "INSERT INTO aluno (id, nome, email, cpf, dataDeNascimento, naturalidade, endereco) VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		stmt.setInt(1,aluno.getId());
		stmt.setString(2,aluno.getNome());
		stmt.setString(3,aluno.getEmail());
		stmt.setString(4,aluno.getCpf());
		stmt.setString(5,aluno.getDataDeNascimento());//aaaa/mm/dd
		stmt.setString(6,aluno.getNaturalidade());
		stmt.setString(7,aluno.getEndereco());
		
		stmt.executeQuery();
		stmt.close();
		con.close();
		
		System.out.println("Insercao finalizada!");
	}
	
	public void deletar(int id) throws SQLException {
		String sql = "DELETE FROM aluno WHERE ID = " + id;
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.executeQuery();
		stmt.close();
		
		System.out.println("Remocao finalizada!");
	}
	
	
	public void alterar(int id, String s) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String sql = "UPDATE aluno SET " + s + " WHERE id = " + id;
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.executeQuery(sql);
		
		sc.close();
		stmt.close();
		
		System.out.println("Alteracao finalizada!");
	}
}
