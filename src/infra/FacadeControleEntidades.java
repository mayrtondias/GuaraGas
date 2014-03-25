package infra;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Cliente;
import model.Funcionario;
import model.Usuario;
import excecoes.Excecoes;

public class FacadeControleEntidades {
	
	private static FacadeControleEntidades myInstance=null;
	private InsereCliente cliente=null;
	private InsereUsuario usuario=null;
	private InsereFuncionario funcionario=null;
    //Excecoes exercoes;
    Command c;
    
    private FacadeControleEntidades(int op){
    	cliente=new InsereCliente(op);
    	usuario=new InsereUsuario(op);
    	funcionario=new InsereFuncionario(op);
        
    }
    
    public synchronized static FacadeControleEntidades getInstance(int op) {  
        
        if (myInstance == null) {
            myInstance = new FacadeControleEntidades(op);
        }
        
        return myInstance;  
    }
    
    public void inserirUsuario(String nome, int senha, String cpf){
        try {
        	c=usuario;
            c.exercute(new Usuario(nome,senha,cpf));
        } catch (Excecoes e) {
            e.trataExcecoes();
        }
    }
    
    public void inserirCliente(String nome, String codigo){
        try {
        	c=cliente;
            c.exercute(new Cliente(nome, codigo));
        } catch (Excecoes ex) {
            Logger.getLogger(FacadeControleEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserirFuncionario(String nome, String codigo){
        try {
        	c=funcionario;
            c.exercute(new Funcionario (nome, codigo));
        } catch (Excecoes ex) {
            Logger.getLogger(FacadeControleEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LinkedList<Usuario> listAllUsuarios(){
    	c=usuario;
        return c.lista();
    }
    
    public  LinkedList<Cliente> listAllClientes(){
    	c=cliente;
        return c.lista();
    }
    
    public LinkedList<Funcionario> listAllFuncionarios(){
    	c=funcionario;
        return c.lista();
    }
}
