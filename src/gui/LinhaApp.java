package gui;

import infra.FacadeControleEntidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import model.Cliente;
import model.Funcionario;
import model.Usuario;

public class LinhaApp extends GuiFactory {

	FacadeControleEntidades facade ;
	
	public LinhaApp(int op){
		facade = FacadeControleEntidades.getInstance(op);
	}
	
	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		String aux = "";
		int op = 0;

		while (true) {

			do {
				try {
					// Apresentacao de opcoes
					System.out.println("Forneca uma das opcoes \n\n"
							+ "1 - Cadastro de Usuarios \n"
							+ "2 - Cadastro de Clientes \n"
							+ "3 - Cadastro de Funcionarios \n"
							+ "4 - Listar Usuarios \n"
							+ "5 - Listar Clientes \n"
							+ "6 - Listar Funcionarios \n" + "0 - Sair \n");
					op = scan.nextInt();
					break;
				} catch (NumberFormatException evento) {
					System.out
							.println("O valor inserido deverá ser um numero inteiro!");
				}
			} while (true);

			switch (op) {

			case 1:// opção do cadastro de usuario
				while (true) {
					try {
						boolean testeNome;
						System.out.println("Forneca seu nome");
						String nome = scan.next();

						testeNome = verificarCampo(nome, 50, 5);

						System.out.println("Forneca sua senha");
						int senha = scan.nextInt();

						System.out.println("Forneca seu CPF");
						String cpf = scan.next();

						
						facade.inserirUsuario(nome, senha, cpf);
						break;
						

					} catch (NumberFormatException evento) {
						System.out
								.println("Formato inválido,informe valores númericos");
					}
				}
				break;
			case 2:// opção do cadastro de cliente
				while (true) {
					try {
						System.out.println("Forneca seu nome");
						String nome = scan.next();
						System.out
								.println("Forneca seu codigo de identificacao (numeros inteiros)");
						String codigo = scan.next();

						facade.inserirCliente(nome, codigo);
						break;
					} catch (NumberFormatException evento) {
						System.out
								.println("Formato inválido,informe valores númericos");
					}
				}
				break;

			case 3:// opção do cadastro de funcionario
				while (true) {
					try {
						System.out.println("Forneca seu nome");
						String nome = scan.next();
						System.out
								.println("Forneca seu codigo de identificacao (numeros inteiros)");
						String codigo = scan.next();

						facade.inserirFuncionario(nome, codigo);
						break;
					} catch (NumberFormatException evento) {
						System.out
								.println("Formato inválido,informe valores númericos");
					}
				}
				break;

			case 4:// opção listar usuario
				LinkedList<Usuario> usuarios;
				aux = "";

				usuarios = facade.listAllUsuarios();
				for (Usuario list : usuarios) {
					aux = "" + aux + "" + list.toString();
				}
				System.out.println(aux);
				break;

			case 5:// opção listar cliente
				LinkedList<Cliente> cli = facade.listAllClientes();
				;
				aux = "";

				for (Cliente list : cli) {
					aux = "" + aux + "" + list.toString();
				}
				System.out.println(aux);
				break;

			case 6:// opção listar funcionario
				LinkedList<Funcionario> funcionarios;
				aux = "";

				funcionarios = facade.listAllFuncionarios();
				for (Funcionario list : funcionarios) {
					aux = "" + aux + "" + list.toString();
				}
				System.out.println(aux);
				break;

			case 0:// encerramento do programa
				scan.close();
				System.exit(0);
				break;

			default:
				System.out.println("Opcao Inválida");
			}
		}

	}

	public static boolean verificarCampo(String campo, int max, int min) {
		if ((campo.length() > max) || (campo.length() < min)) {
			return false;
		}

		for (int i = 0; i < campo.length(); i++) {
			if (Character.isDigit(campo.charAt(i)))
				return false;
		}

		return true;
	}

	public static boolean verificarEmail(String email) {

		if (email.indexOf("@") < 0)
			return false;
		if ((email.charAt(0) == '@')
				|| (email.charAt(email.length() - 1) == '@'))
			return false;
		return true;
	}

}
