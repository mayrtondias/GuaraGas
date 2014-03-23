package infra;

import java.util.Iterator;
import java.util.LinkedList;

import model.Cliente;

public class ClienteMemoria extends ClienteDAOFactory {
	
	private static LinkedList<Cliente> clientes=null;
	
	public ClienteMemoria(){
		clientes = new LinkedList<>();
	}

	@Override
	public Cliente get(String pesquisa) {
		Iterator<Cliente> it = clientes.iterator();
		Cliente c;
		
		while(it.hasNext()){ 
			c = it.next();
			if(c.getCodigo().equals(pesquisa)) return c; 
        	
		}
			return null;
	}

	@Override
	public void add(Cliente o) {
		clientes.add(o);
		
	}

	@Override
	public void delete(Cliente o) {
		Iterator<Cliente> it = clientes.iterator();
        while(it.hasNext()){  
            if(it.next().equals(o)) it.remove();  
        }
		
	}

	@Override
	public void update(Cliente o) {
		
	}

	@Override
	public LinkedList<Cliente> listAll() {
		return clientes;
	}

	

	

}
