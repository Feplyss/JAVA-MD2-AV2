package appView;

import java.sql.SQLException;
import java.util.Scanner;

import dao.AlunoDao;
import model.Aluno;

public class Main {

	public static void main(String[] args) {
		
		char op;
		Scanner sc = new Scanner(System.in);
		try {
			
			AlunoDao dao = new AlunoDao();
			
			System.out.println("=========================================");
			System.out.println("Qual operacao deseja realizar?");
			System.out.println("Listar..............: 1");
			System.out.println("Listar por letra....: 2");
			System.out.println("Adicionar...........: 3");
			System.out.println("Deletar.............: 4");
			System.out.println("Alterar.............: 5");
			System.out.println("=========================================");
			op = sc.nextLine().charAt(0);
			
			switch(op) {
			
			case '1':
				dao.listar();
				break;
				
			case '2':
				System.out.print("Letra...............: ");
				String s = sc.nextLine() + "%";
				dao.listarPelaLetra(s);
				break;
				
			case '3':
				Aluno aluno = new Aluno();
				
				System.out.print("Nome................: ");
				aluno.setNome(sc.nextLine());
				System.out.print("E-mail..............: ");
				aluno.setEmail(sc.nextLine());
				System.out.print("CPF.................: ");
				aluno.setCpf(sc.nextLine());
				System.out.print("Nascimento (aaaa/mm/dd): ");
				aluno.setDataDeNascimento(sc.nextLine());//aaaa/mm/dd
				System.out.print("Naturalidade........: ");
				aluno.setNaturalidade(sc.nextLine());
				System.out.print("Endereco............: ");
				aluno.setEndereco(sc.nextLine());
				
				dao.adicionar(aluno);
				break;
				
			case '4':
				System.out.print("ID..................: ");
				int id = Integer.parseInt(sc.nextLine());
				dao.deletar(id);
				break;
				
			case '5':
				String s2 = "";
				int i = 0;
				char op2;
				
				System.out.print("ID..................: ");
				int id2 = Integer.parseInt(sc.nextLine());
				
				System.out.println("=========================================");
				System.out.println("Qual coluna deseja alterar?");
				System.out.println("Nome................: 1");
				System.out.println("E-mail..............: 2");
				System.out.println("CPF.................: 3");
				System.out.println("Nascimento..........: 4");
				System.out.println("Naturalidade........: 5");
				System.out.println("Endereco............: 6");
				System.out.println("=========================================");
				
				while(true) {
					op2 = sc.nextLine().charAt(0);
					switch(op2) {
					
					case '1':
						if(i > 0) {s2 += ", ";}
						
						System.out.print("Nome................: ");
						s2 += "nome = '" + sc.nextLine() + "'";
						i++;
						break;
							
					case '2':
						if(i > 0) {s2 += ", ";}
							
						System.out.print("E-mail..............: ");
						s2 += "email = '" + sc.nextLine() + "'";
						i++;
						break;
							
					case '3':
						if(i > 0) {s2 += ", ";}
							
						System.out.print("CPF.................: ");
						s2 += "cpf = '" + sc.nextLine() + "'";
						i++;
						break;
							
					case '4':
						if(i > 0) {s2 += ", ";}
							
						System.out.print("Nascimento (aaaa/mm/dd): ");
						s2 += "nascimento = '" + sc.nextLine() + "'";
						i++;
						break;
							
					case '5':
						if(i > 0) {s2 += ", ";}
							
						System.out.print("Naturalidade........: ");
						s2 += "naturalidade = '" + sc.nextLine() + "'";
						i++;
						break;
						
					case '6':
						if(i > 0) {s2 += ", ";}
						
						System.out.print("Endereco............: ");
						s2 += "endereco = '" + sc.nextLine() + "'";
						i++;
						break;
						
					default:
						System.out.println("Opcao invalida!");
						break;
					}
					
					System.out.println("Deseja alterar outro valor? (S/N)");
					char end = sc.nextLine().charAt(0);
					if(end == 'N' || end == 'n') {
						break;
					}
					System.out.println("Qual coluna deseja alterar?");
				}
				
				dao.alterar(id2, s2);
				break;
				
			default:
				System.out.println("Opcao invalida!");
				break;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		
		sc.close();
	}
}
