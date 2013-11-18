/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import excecoes.Excecoes;
import java.util.ArrayList;
import model.Usuario;
import gui.*;
//import infra.*;
/**
 *
 * @author aluno
 */
public class ControleUsuario {
    ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
    //Usuario aux = new Usuario();
    
    public void inserirUsuario(String nome, int senha,String cpf ) throws Excecoes{
        if(verificarDuplicidade(cpf)){
            throw new Excecoes("Cpf já existente \nAlgum usuario cadastrado já o possui");
        }else{
            Usuario aux = new Usuario(nome,senha,cpf);
            usuarios.add(aux);
        }
            
    }
    
    public boolean verificarDuplicidade(String cpf){
        for(Usuario asd : usuarios){
            if(asd.getCpf().equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
}
