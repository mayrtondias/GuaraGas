package infra;

import java.util.ArrayList;

import excecoes.Excecoes;
import model.Cliente;
import model.Funcionario;
import model.Usuario;

public class ControleEntidades {
	ArrayList <Funcionario> funcionarios = new ArrayList <Funcionario>();
    ArrayList <Cliente> clientes = new ArrayList <Cliente>();
    ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
    
    //-------------------------------------Funcionario--------------------------------------------------------------------------------------
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir funcionario
    public void inserirFuncionario(String nome, String codigo ) throws Excecoes{
       
        int verificacao = Integer.parseInt(codigo);
        if(verificarDuplicidadeFuncionario(codigo)){
            throw new Excecoes("C�digo j� existente \nAlgum funcionario cadastrado j� o possui");
        }else{
            Funcionario aux = new Funcionario(nome,codigo);
            funcionarios.add(aux);
        }
            
    }
    //verifica a exist�ncia de um funcionario com o mesmo codigo
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
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir cliente
    public void inserirCliente(String nome, String codigo ) throws Excecoes{
        if(verificarDuplicidadeCliente(codigo)){
            throw new Excecoes("C�digo j� existente \nAlgum cliente cadastrado j� o possui");
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
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir  
    public void inserirUsuario(String nome, int senha,String cpf ) throws Excecoes{
        if(verificarDuplicidadeUsuario(cpf)){
            throw new Excecoes("Cpf j� existente \nAlgum usuario cadastrado j� o possui");
        }else{
            Usuario aux = new Usuario(nome,senha,cpf);
            usuarios.add(aux);
        }
            
    }
    //verifica a existencia de um usu�rio com o mesmo codigo
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