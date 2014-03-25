package infra;
import java.util.LinkedList;

import excecoes.Excecoes;
import model.Cliente;

public class InsereCliente implements Command{
	
    ClienteDAOFactory ClienteDAO=null;
	    
    public InsereCliente(int op){
    	ClienteDAO = ClienteDAOFactory.getDAOFactory(op);
    }    
     
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


	@Override
	public void exercute(Object c) throws Excecoes {
		inserirCliente((Cliente)c);
		
	}


	@Override
	public LinkedList<Cliente> lista() {
		return listAllClientes();
	}
    
}