package infra;

import java.util.LinkedList;

import excecoes.Excecoes;
import model.Cliente;
import model.Funcionario;
import model.Usuario;

public class ControleEntidades {
	
    ClienteDAOFactory ClienteDAO=null;
	FuncionarioDAOFactory FuncionarioDAO = null;
	UsuarioDAOFactory UsuarioDAO = null;
    
    public ControleEntidades(int whichFactory){
    	ClienteDAO = ClienteDAOFactory.getDAOFactory(whichFactory);
    	FuncionarioDAO = FuncionarioDAOFactory.getDAOFactory(whichFactory);
    	UsuarioDAO = UsuarioDAOFactory.getDAOFactory(whichFactory);
    }
   
    //-------------------------------------Funcionario--------------------------------------------------------------------------------------
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir funcionario
    public void inserirFuncionario(Funcionario f ) throws Excecoes{
       
        int verificacao = Integer.parseInt(f.getCodigo());
        if(verificarDuplicidadeFuncionario(f.getCodigo())){
            throw new Excecoes("C�digo j� existente \nAlgum funcionario cadastrado j� o possui");
        }else{
        	FuncionarioDAO.add(f);
        }
            
    }
    //verifica a exist�ncia de um funcionario com o mesmo codigo
    public boolean verificarDuplicidadeFuncionario(String codigo){
    	Funcionario c=(Funcionario)FuncionarioDAO.get(codigo);
    	if(c!=null) return true;
        return false;
    }
    
    public LinkedList<Funcionario> listAllFuncionarios(){
    	return FuncionarioDAO.listAll();
    }
    
     //-------------------------------------------------Cliente------------------------------------------------------------------------------
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir cliente
    public void inserirCliente(Cliente c ) throws Excecoes{
        if(verificarDuplicidadeCliente(c.getCodigo())){
            throw new Excecoes("C�digo j� existente \nAlgum cliente cadastrado j� o possui");
        }else{
        	ClienteDAO.add(c);
        }
            
    }
    //verifica a existencia de um cliente com o mesmo codigo
    public boolean verificarDuplicidadeCliente(String codigo){
    	Cliente c=(Cliente)ClienteDAO.get(codigo);
    	if(c!=null) return true;
        return false;
    }
    
    public LinkedList<Cliente> listAllClientes(){
        return ClienteDAO.listAll();
    }
    
    //----------------------------------------------------Usuario---------------------------------------------------------------------------
    //fun��o responsavel pelo tratamento de exce��o na opera��o de inserir  
    public void inserirUsuario(Usuario u) throws Excecoes{
        if(verificarDuplicidadeUsuario(u.getCpf())){
            throw new Excecoes("Cpf j� existente \nAlgum usuario cadastrado j� o possui");
        }else{
        	UsuarioDAO.add(u);
        }
            
    }
    //verifica a existencia de um usu�rio com o mesmo codigo
    public boolean verificarDuplicidadeUsuario(String cpf){
    	Usuario c=(Usuario)UsuarioDAO.get(cpf);
    	if(c!=null) return true;
        return false;
    }
    
    public LinkedList<Usuario> listAllUsuarios(){
        return UsuarioDAO.listAll();
    }
}