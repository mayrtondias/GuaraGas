package infra;

import java.util.LinkedList;

import excecoes.Excecoes;
import model.Usuario;

public class InsereUsuario implements Command{	
    
	UsuarioDAOFactory UsuarioDAO = null;
    
    public InsereUsuario(int op){
    	
    	UsuarioDAO = UsuarioDAOFactory.getDAOFactory(op);
    }
    
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

	@Override
	public void exercute(Object c) throws Excecoes {
		inserirUsuario((Usuario)c);	
	}

	@Override
	public LinkedList<Usuario> lista() {
		return UsuarioDAO.listAll();
	}
}