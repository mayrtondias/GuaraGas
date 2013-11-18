/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import excecoes.Excecoes;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.ControleUsuario;

/**
 *
 * @author aluno
 */
public class GuaraGasApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControleUsuario obj = new ControleUsuario();
        int op;    
        while(true){
           
           op = Integer.parseInt(JOptionPane.showInputDialog("Forneca uma das opcoes \n\n"
                   + "1 - Cadastro de Usuarios \n"
                   + "2 - Cadastro de Clientes \n"
                   + "3 - Cadastro de Funcionarios \n"
                   + "0 - Sair \n"));
           
           switch (op){
               
            case 1:
                while(true){   
                    try{
                        String nome = JOptionPane.showInputDialog("Forneca seu nome");
                        String aux = JOptionPane.showInputDialog("Forneca sua senha");
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
            case 2:
               
                break;
            case 0:
                System.exit(0);
                break;
            default :
                JOptionPane.showMessageDialog(null, "Opcao Inválida");
            } 
            
     }
        
    }
}
        

