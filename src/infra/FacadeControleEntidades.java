package infra;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import excecoes.Excecoes;

public class FacadeControleEntidades {
	
	private static FacadeControleEntidades myInstance=null;
    //Excecoes exercoes;
    ControleEntidades obj;
    
    private FacadeControleEntidades(){
        obj = new ControleEntidades();
    }
    
    public synchronized static FacadeControleEntidades getInstance() {  
        
        if (myInstance == null) {
            myInstance = new FacadeControleEntidades();
        }
        
        return myInstance;  
    }
    
    public void inserirUsuario(String nome, int senha, String cpf){
        try {
            obj.inserirUsuario(nome,senha,cpf);
        } catch (Excecoes e) {
            e.trataExcecoes();
        }
    }
    
    public void inserirCliente(String nome, String codigo){
        try {
            obj.inserirCliente(nome, codigo);
        } catch (Excecoes ex) {
            Logger.getLogger(FacadeControleEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inserirFuncionario(String nome, String codigo){
        try {
            obj.inserirFuncionario(nome, codigo);
        } catch (Excecoes ex) {
            Logger.getLogger(FacadeControleEntidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList listAllUsuarios(){
        return obj.listAllUsuarios();
    }
    
    public  ArrayList listAllClientes(){
        return obj.listAllClientes();
    }
    
    public ArrayList listAllFuncionarios(){
        return obj.listAllFuncionarios();
    }
}
