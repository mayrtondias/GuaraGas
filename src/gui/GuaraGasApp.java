/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import excecoes.Excecoes;
import java.util.ArrayList;
import java.util.*;
import javax.swing.JOptionPane;
import infra.ControleEntidades;
import model.Cliente;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author aluno
 */
public class GuaraGasApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControleEntidades obj = new ControleEntidades();
        String aux = "";
        
        int op;    
        while(true){
           
            //Apresentacao de opcoes
           op = Integer.parseInt(JOptionPane.showInputDialog("Forneca uma das opcoes \n\n"
                   + "1 - Cadastro de Usuarios \n"
                   + "2 - Cadastro de Clientes \n"
                   + "3 - Cadastro de Funcionarios \n"
                   + "4 - Listar Usuarios \n"
                   + "5 - Listar Clientes \n"
                   + "6 - Listar Funcionarios \n"
                   + "0 - Sair \n"));
           
           switch (op){
               
            case 1://opção do cadastro de usuario
                while(true){   
                    try{
                        String nome = JOptionPane.showInputDialog("Forneca seu nome");
                        aux = JOptionPane.showInputDialog("Forneca sua senha");
                        int senha = Integer.parseInt(aux);

                        String cpf = JOptionPane.showInputDialog("Forneca seu CPF");
                        obj.inserirUsuario(nome,senha,cpf);
                        break;

                    }catch(NumberFormatException evento){
                        JOptionPane.showMessageDialog(null, "Formato inválido,informe valores númericos");
                    }catch(Excecoes evento) {
                              JOptionPane.showMessageDialog(null, evento.trataExcecoes());
                          }
                    }
                break;
            case 2://opção do cadastro de cliente
                 while(true){   
                    try{
                        String nome = JOptionPane.showInputDialog("Forneca seu nome");
                        String codigo = JOptionPane.showInputDialog("Forneca seu codigo de identificacao (numeros inteiros)");
                        int testa_excecao = Integer.parseInt(codigo); //apenas para garantir que o codigo eh em numeros inteiros
                        
                        obj.inserirCliente(nome,codigo);
                        break;
                    }catch(NumberFormatException evento){
                        JOptionPane.showMessageDialog(null, "Formato inválido,informe valores númericos");
                    }catch(Excecoes evento) {
                              JOptionPane.showMessageDialog(null, evento.trataExcecoes());
                          }
                    }
                break;
                
            case 3://opção do cadastro de funcionario
                 while(true){   
                    try{
                        String nome = JOptionPane.showInputDialog("Forneca seu nome");
                        String codigo = JOptionPane.showInputDialog("Forneca seu codigo de identificacao (numeros inteiros)");
                        int testa_excecao = Integer.parseInt(codigo); //apenas para garantir que o codigo eh em numeros inteiros
                        
                        obj.inserirFuncionario(nome,codigo);
                        break;
                    }catch(NumberFormatException evento){
                        JOptionPane.showMessageDialog(null, "Formato inválido,informe valores númericos");
                    }catch(Excecoes evento) {
                              JOptionPane.showMessageDialog(null, evento.trataExcecoes());
                          }
                    }
                break;
                
            case 4://opção listar usuario
                ArrayList <Usuario> usuarios;
                aux = "";
                
                usuarios = obj.listAllUsuarios();
                for(Usuario list : usuarios){
                    aux = "" + aux + "" + list.toString();
                }
                JOptionPane.showMessageDialog(null, aux);
                break;
                
            case 5://opção listar cliente
                ArrayList <Cliente> clientes;
                aux = "";
                
                clientes = obj.listAllClientes();
                for(Cliente list : clientes){
                    aux = "" + aux + "" + list.toString();
                }
                JOptionPane.showMessageDialog(null, aux);              
                break;
                
            case 6://opção listar funcionario
                ArrayList <Funcionario> funcionarios;
                aux = "";
                
                funcionarios = obj.listAllFuncionarios();
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
}
        

