package gui;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Funcionario;
import model.Usuario;
import infra.FacadeControleEntidades;

public class GuaraGasApp {
	public static void main(String[] args) {
        
        FacadeControleEntidades facade = FacadeControleEntidades.getInstance();
        String aux = "";
        
        int op=0; 
        
        
        while(true){
            
            do{
                try{
                    //Apresentacao de opcoes
                    op = Integer.parseInt(JOptionPane.showInputDialog("Forneca uma das opcoes \n\n"
                            + "1 - Cadastro de Usuarios \n"
                            + "2 - Cadastro de Clientes \n"
                            + "3 - Cadastro de Funcionarios \n"
                            + "4 - Listar Usuarios \n"
                            + "5 - Listar Clientes \n"
                            + "6 - Listar Funcionarios \n"
                            + "0 - Sair \n"));
                    break;
                }catch(NumberFormatException evento){
                    JOptionPane.showMessageDialog(null,"O valor inserido deverá ser um numero inteiro!");
                }
            }while(true);
            
            switch (op){
               
                case 1://opção do cadastro de usuario
                    while(true){   
                        try{
                        	boolean testeNome;
                            String nome = JOptionPane.showInputDialog("Forneca seu nome");
                           
                            testeNome=verificarCampo(nome, 50, 5);
                            
                            aux = JOptionPane.showInputDialog("Forneca sua senha");
                            int senha = Integer.parseInt(aux);

                            String cpf = JOptionPane.showInputDialog("Forneca seu CPF");
                            
                            
                            if(testeNome==true){
                            	facade.inserirUsuario(nome,senha,cpf);
                            	break;
                            }

                        }catch(NumberFormatException evento){
                            JOptionPane.showMessageDialog(null, "Formato inválido,informe valores númericos");
                        }
                    }
                break;
            case 2://opção do cadastro de cliente
                 while(true){   
                    try{
                        String nome = JOptionPane.showInputDialog("Forneca seu nome");
                        String codigo = JOptionPane.showInputDialog("Forneca seu codigo de identificacao (numeros inteiros)");
                        int testa_excecao = Integer.parseInt(codigo); //apenas para garantir que o codigo eh em numeros inteiros
                        
                        facade.inserirCliente(nome,codigo);
                        break;
                    }catch(NumberFormatException evento){
                        JOptionPane.showMessageDialog(null, "Formato inválido,informe valores númericos");
                    }
                }
                break;
                
            case 3://opção do cadastro de funcionario
                 while(true){   
                    try{
                        String nome = JOptionPane.showInputDialog("Forneca seu nome");
                        String codigo = JOptionPane.showInputDialog("Forneca seu codigo de identificacao (numeros inteiros)");
                        int testa_excecao = Integer.parseInt(codigo); //apenas para garantir que o codigo eh em numeros inteiros
                        
                        facade.inserirFuncionario(nome,codigo);
                        break;
                    }catch(NumberFormatException evento){
                        JOptionPane.showMessageDialog(null, "Formato inválido,informe valores númericos");
                    }
                    }
                break;
                
            case 4://opção listar usuario
                ArrayList <Usuario> usuarios;
                aux = "";
                
                usuarios = facade.listAllUsuarios();
                for(Usuario list : usuarios){
                    aux = "" + aux + "" + list.toString();
                }
                JOptionPane.showMessageDialog(null, aux);
                break;
                
            case 5://opção listar cliente
                LinkedList<Cliente> cli = facade.listAllClientes();;
                aux = "";
                
                
                for(Cliente list : cli){
                    aux = "" + aux + "" + list.toString();
                }
                JOptionPane.showMessageDialog(null, aux);              
                break;
                
            case 6://opção listar funcionario
                ArrayList <Funcionario> funcionarios;
                aux = "";
                
                funcionarios = facade.listAllFuncionarios();
                for(Funcionario list : funcionarios){
                    aux = "" + aux + "" + list.toString();
                }
                JOptionPane.showMessageDialog(null, aux);
                break;
                
            case 0://encerramento do programa
                System.exit(0);
                break;
                
            default :
                JOptionPane.showMessageDialog(null, "Opcao Inválida");
            } 
     }
        
    }
    
    public static boolean verificarCampo(String campo,int max, int min){
        
        if((campo.length()>max)||(campo.length()<min)){
            return false;
        }
        
        for (int i = 0; i < campo.length(); i++) {  
           if (Character.isDigit(campo.charAt(i)))   
              return false;  
        }
        
        return true;
    }
    
    public static boolean verificarEmail(String email){
    	
    	if (email.indexOf("@") < 0) 
    		return false;
    	if((email.charAt(0)=='@')||(email.charAt(email.length()-1)=='@'))
    		return false;
    	return true;	
    }
}