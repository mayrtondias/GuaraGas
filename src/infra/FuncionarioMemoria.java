package infra;

import java.util.Iterator;
import java.util.LinkedList;

import model.Cliente;
import model.Funcionario;

public class FuncionarioMemoria extends FuncionarioDAOFactory{

	private static LinkedList<Funcionario> funcionarios;
	
	public FuncionarioMemoria(){
		funcionarios = new LinkedList<>();
	}

	@Override
	public Funcionario get(String pes) {
		Iterator<Funcionario> it = funcionarios.iterator();
		Funcionario f;
		
		while(it.hasNext()){ 
			f = it.next();
			if(f.getCodigo().equals(pes)) return f; 
        	
        }
			return null;
	}

	@Override
	public void add(Funcionario o) {
		funcionarios.add(o);
	}

	@Override
	public void delete(Funcionario o) {
		Iterator<Funcionario> it = funcionarios.iterator();
        while(it.hasNext()){  
            if(it.next().equals(o)) it.remove();  
        }
		
	}

	@Override
	public void update(Funcionario o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedList<Funcionario> listAll() {
		return funcionarios;
	}
	
	
}
