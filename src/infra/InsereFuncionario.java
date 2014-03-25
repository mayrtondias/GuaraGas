package infra;

import model.Funcionario;
import excecoes.Excecoes;

import java.util.LinkedList;

public class InsereFuncionario implements Command{
	

	FuncionarioDAOFactory FuncionarioDAO = null;
	
    public InsereFuncionario(int op){
    	
    	FuncionarioDAO = FuncionarioDAOFactory.getDAOFactory(op);
    	
    }
   
    
    //função responsavel pelo tratamento de exceção na operação de inserir funcionario
    public void inserirFuncionario(Funcionario f ) throws Excecoes{
       
        int verificacao = Integer.parseInt(f.getCodigo());
        if(verificarDuplicidadeFuncionario(f.getCodigo())){
            throw new Excecoes("Código já existente \nAlgum funcionario cadastrado já o possui");
        }else{
        	FuncionarioDAO.add(f);
        }
            
    }
    //verifica a existência de um funcionario com o mesmo codigo
    public boolean verificarDuplicidadeFuncionario(String codigo){
    	Funcionario c=(Funcionario)FuncionarioDAO.get(codigo);
    	if(c!=null) return true;
        return false;
    }
    
    public LinkedList<Funcionario> listAllFuncionarios(){
    	return FuncionarioDAO.listAll();
    }

	@Override
	public void exercute(Object c) throws Excecoes{
		inserirFuncionario((Funcionario)c );
		
	}
	@Override
	public LinkedList<Funcionario> lista() {
		
		return listAllFuncionarios();
	}
}
