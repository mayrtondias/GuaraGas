/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra;

import excecoes.Excecoes;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Funcionario;
import model.Usuario;

/**
 *
 * @author Vitor
 */
//Aqui estará todas as operacoes logicas aplicadas aos ArrayList's das classes : Usuario, Cliente e Funcionario
public class ControleEntidades {
    
    ArrayList <Funcionario> funcionarios = new ArrayList <Funcionario>();
    ArrayList <Cliente> clientes = new ArrayList <Cliente>();
    ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
    
    //-------------------------------------Funcionario--------------------------------------------------------------------------------------
    //função responsavel pelo tratamento de exceção na operação de inserir funcionario
    public void inserirFuncionario(String nome, String codigo ) throws Excecoes{
       
        int verificacao = Integer.parseInt(codigo);
        if(verificarDuplicidadeFuncionario(codigo)){
            throw new Excecoes("Código já existente \nAlgum funcionario cadastrado já o possui");
        }else{
            Funcionario aux = new Funcionario(nome,codigo);
            funcionarios.add(aux);
        }
            
    }
    //verifica a existência de um funcionario com o mesmo codigo
    public boolean verificarDuplicidadeFuncionario(String codigo){
        for(Funcionario aux2 : funcionarios){
            if(aux2.getCodigo().equalsIgnoreCase(codigo)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList listAllFuncionarios(){
        return funcionarios;
    }
    
     //-------------------------------------------------Cliente------------------------------------------------------------------------------
    //função responsavel pelo tratamento de exceção na operação de inserir cliente
    public void inserirCliente(String nome, String codigo ) throws Excecoes{
        if(verificarDuplicidadeCliente(codigo)){
            throw new Excecoes("Código já existente \nAlgum cliente cadastrado já o possui");
        }else{
            Cliente aux = new Cliente(nome,codigo);
            clientes.add(aux);
        }
            
    }
    //verifica a existencia de um cliente com o mesmo codigo
    public boolean verificarDuplicidadeCliente(String codigo){
        for(Cliente aux2 : clientes){
            if(aux2.getCodigo().equalsIgnoreCase(codigo)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList listAllClientes(){
        return clientes;
    }
    
    //----------------------------------------------------Usuario---------------------------------------------------------------------------
    //função responsavel pelo tratamento de exceção na operação de inserir  
    public void inserirUsuario(String nome, int senha,String cpf ) throws Excecoes{
        if(verificarDuplicidadeUsuario(cpf)){
            throw new Excecoes("Cpf já existente \nAlgum usuario cadastrado já o possui");
        }else{
            Usuario aux = new Usuario(nome,senha,cpf);
            usuarios.add(aux);
        }
            
    }
    //verifica a existencia de um usuário com o mesmo codigo
    public boolean verificarDuplicidadeUsuario(String cpf){
        for(Usuario aux : usuarios){
            if(aux.getCpf().equalsIgnoreCase(cpf)){
                return true;
            }
        }
        return false;
    }
    
    public ArrayList listAllUsuarios(){
        return usuarios;
    }
}
