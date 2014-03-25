package gui;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Funcionario;
import model.Usuario;
import infra.FacadeControleEntidades;
import infra.Interador;

public class GuiApp extends GuiFactory {

	FacadeControleEntidades facade;

	public GuiApp(int op) {
		facade = FacadeControleEntidades.getInstance(op);
	}

	@Override
	public void execute() {

		String aux = "";
		ValidaStrategy valida = new ValidaStrategy();
		int op = 0;
		boolean testeNome=false;

		while (true) {

			do {
				try {
					// Apresentacao de opcoes
					op = Integer.parseInt(JOptionPane
							.showInputDialog("Forneca uma das opcoes \n\n"
									+ "1 - Cadastro de Usuarios \n"
									+ "2 - Cadastro de Clientes \n"
									+ "3 - Cadastro de Funcionarios \n"
									+ "4 - Listar Usuarios \n"
									+ "5 - Listar Clientes \n"
									+ "6 - Listar Funcionarios \n"
									+ "0 - Sair \n"));
					break;
				} catch (NumberFormatException evento) {
					JOptionPane.showMessageDialog(null,
							"O valor inserido deverá ser um numero inteiro!");
				}
			} while (true);

			switch (op) {

			case 1:// opção do cadastro de usuario
				while (true) {
					try {
						
						String nome = JOptionPane
								.showInputDialog("Forneca seu nome");

						testeNome = valida.verificarCampo(nome, 50, 5);

						aux = JOptionPane.showInputDialog("Forneca sua senha");
						int senha = Integer.parseInt(aux);

						String cpf = JOptionPane
								.showInputDialog("Forneca seu CPF");
						
						if(testeNome){
							facade.inserirUsuario(nome, senha, cpf);
						}else{
							JOptionPane.showMessageDialog(null,
									"O nome deve ser inferior a 50 e superior a 5");
						}

						
						break;

					} catch (NumberFormatException evento) {
						JOptionPane.showMessageDialog(null,
								"Formato inválido,informe valores númericos");
					}
				}
				break;
			case 2:// opção do cadastro de cliente
				while (true) {
					try {
						String nome = JOptionPane
								.showInputDialog("Forneca seu nome");
						testeNome = valida.verificarCampo(nome, 50, 5);
						String codigo = JOptionPane
								.showInputDialog("Forneca seu codigo de identificacao (numeros inteiros)");
						int testa_excecao = Integer.parseInt(codigo); 

						if(testeNome){
							facade.inserirCliente(nome, codigo);
						}else{
							JOptionPane.showMessageDialog(null,
									"O nome deve ser inferior a 50 e superior a 5");
						}

						break;
					} catch (NumberFormatException evento) {
						JOptionPane.showMessageDialog(null,
								"Formato inválido,informe valores númericos");
					}
				}
				break;

			case 3:// opção do cadastro de funcionario
				while (true) {
					try {
						String nome = JOptionPane
								.showInputDialog("Forneca seu nome");
						testeNome = valida.verificarCampo(nome, 50, 5);
						String codigo = JOptionPane
								.showInputDialog("Forneca seu codigo de identificacao (numeros inteiros)");
						int testa_excecao = Integer.parseInt(codigo);
						
						if(testeNome){
							facade.inserirFuncionario(nome, codigo);
						}else{
							JOptionPane.showMessageDialog(null,
									"O nome deve ser inferior a 50 e superior a 5");
						}

						break;
					} catch (NumberFormatException evento) {
						JOptionPane.showMessageDialog(null,
								"Formato inválido,informe valores númericos");
					}
				}
				break;

			case 4:// opção listar usuario
				LinkedList<Usuario> usuarios;
				aux = "";

				usuarios = facade.listAllUsuarios();
				
				Interador<Usuario> i = new Interador<Usuario>(usuarios);
				
				while (i.hasNext()==true) {
					aux = "" + aux + ""+i.next().toString();
				}
				
				JOptionPane.showMessageDialog(null, aux);
				
				break;

			case 5:// opção listar cliente
				LinkedList<Cliente> cli = facade.listAllClientes();
				
				aux = "";

				Interador<Cliente> j = new Interador<Cliente>(cli);
				
				while (j.hasNext()==true) {
					aux = "" + aux + ""+j.next().toString();
				}
				
				JOptionPane.showMessageDialog(null, aux);
				break;

			case 6:// opção listar funcionario
				LinkedList<Funcionario> funcionarios;
				aux = "";

				funcionarios = facade.listAllFuncionarios();
				Interador<Funcionario> K = new Interador<Funcionario>(funcionarios);
				
				while (K.hasNext()==true) {
					aux = "" + aux + ""+K.next().toString();
				}
				JOptionPane.showMessageDialog(null, aux);
				break;

			case 0:// encerramento do programa
				System.exit(0);
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opcao Inválida");
			}
		}

	}

}
