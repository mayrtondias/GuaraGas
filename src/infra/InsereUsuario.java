package infra;

import java.util.LinkedList;

import excecoes.Excecoes;
import model.Usuario;

public class InsereUsuario implements Command{	
    
	UsuarioDAOFactory UsuarioDAO = null;
    
    public InsereUsuario(int op){
    	
    	UsuarioDAO = UsuarioDAOFactory.getDAOFactory(op);
    }
    
    //função responsavel pelo tratamento de exceção na operação de inserir  
    public void inserirUsuario(Usuario u) throws Excecoes{
        if(verificarDuplicidadeUsuario(u.getCpf())){
            throw new Excecoes("Cpf já existente \nAlgum usuario cadastrado já o possui");
        }else{
        	UsuarioDAO.add(u);
        }
            
    }
    //verifica a existencia de um usuário com o mesmo codigo
    public boolean verificarDuplicidadeUsuario(String cpf){
    	Usuario c=(Usuario)UsuarioDAO.get(cpf);
    	if(c!=null) return true;
        return false;
    }
    
    public LinkedList<Usuario> listAllUsuarios(){
        return UsuarioDAO.listAll();
    }

	@Override
	public void exercute(Object c) throws Excecoes {
		inserirUsuario((Usuario)c);	
	}

	@Override
	public LinkedList<Usuario> lista() {
		return UsuarioDAO.listAll();
	}
}