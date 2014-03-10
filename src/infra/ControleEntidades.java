package infra;

import java.util.ArrayList;


import java.util.LinkedList;

import excecoes.Excecoes;
import model.Cliente;
import model.Funcionario;
import model.Usuario;

public class ControleEntidades {
	ArrayList <Funcionario> funcionarios = new ArrayList <Funcionario>();
    ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
    DAOFactory DAOCliente=null;
    
    public ControleEntidades(int whichFactory){
    	DAOCliente = DAOFactory.getDAOFactory(whichFactory);
    }
   
    //-------------------------------------Funcionario--------------------------------------------------------------------------------------
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir funcionario
    public void inserirFuncionario(Funcionario f ) throws Excecoes{
       
        int verificacao = Integer.parseInt(f.getCodigo());
        if(verificarDuplicidadeFuncionario(f.getCodigo())){
            throw new Excecoes("C�digo j� existente \nAlgum funcionario cadastrado j� o possui");
        }else{
            funcionarios.add(f);
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
    public void inserirCliente(Cliente c ) throws Excecoes{
        if(verificarDuplicidadeCliente(c.getCodigo())){
            throw new Excecoes("C�digo j� existente \nAlgum cliente cadastrado j� o possui");
        }else{
            DAOCliente.add(c);
        }
            
    }
    //verifica a existencia de um cliente com o mesmo codigo
    public boolean verificarDuplicidadeCliente(String codigo){
    	Cliente c=DAOCliente.get(codigo);
    	if(c!=null) return true;
        return false;
    }
    
    public LinkedList<Cliente> listAllClientes(){
        return DAOCliente.listAll();
    }
    
    //----------------------------------------------------Usuario---------------------------------------------------------------------------
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir  
    public void inserirUsuario(Usuario u) throws Excecoes{
        if(verificarDuplicidadeUsuario(u.getCpf())){
            throw new Excecoes("Cpf j� existente \nAlgum usuario cadastrado j� o possui");
        }else{
            
            usuarios.add(u);
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