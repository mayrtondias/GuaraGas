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
    //Excecoes exercoes;
    ControleEntidades obj;
    
    private FacadeControleEntidades(int op){
        obj = new ControleEntidades(op);
    }
    
    public synchronized static FacadeControleEntidades getInstance(int op) {  
        
        if (myInstance == null) {
            myInstance = new FacadeControleEntidades(op);
        }
        
        return myInstance;  
    }
    
    public void inserirUsuario(String nome, int senha, String cpf){
        try {
            obj.inserirUsuario(new Usuario(nome,senha,cpf));
        } catch (Excecoes e) {
            e.trataExcecoes();
        }
    }
    
    public void inserirCliente(String nome, String codigo){
        try {
            obj.inserirCliente(new Cliente(nome, codigo));
        } catch (Excecoes ex) {
            Logger.getLogger(FacadeControleEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserirFuncionario(String nome, String codigo){
        try {
            obj.inserirFuncionario(new Funcionario (nome, codigo));
        } catch (Excecoes ex) {
            Logger.getLogger(FacadeControleEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public LinkedList<Usuario> listAllUsuarios(){
        return obj.listAllUsuarios();
    }
    
    public  LinkedList<Cliente> listAllClientes(){
        return obj.listAllClientes();
    }
    
    public LinkedList<Funcionario> listAllFuncionarios(){
        return obj.listAllFuncionarios();
    }
}
