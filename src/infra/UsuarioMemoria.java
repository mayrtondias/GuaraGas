package infra;

import java.util.Iterator;
import java.util.LinkedList;

import model.Cliente;
import model.Funcionario;
import model.Usuario;

public class UsuarioMemoria extends UsuarioDAOFactory{
	
	private LinkedList<Usuario> usuarios=null;
	
	public UsuarioMemoria(){
		usuarios = new LinkedList<>();
	}

	@Override
	public Usuario get(String pes) {
		Iterator<Usuario> it = usuarios.iterator();
		Usuario u;
		
		while(it.hasNext()){ 
			u = it.next();
			if(u.getCpf().equals(pes)) return u; 
        	
		}
		return null;
	}

	@Override
	public void add(Usuario o) {
		usuarios.add(o);		
	}

	@Override
	public void delete(Usuario o) {
		Iterator<Usuario> it = usuarios.iterator();
        while(it.hasNext()){  
            if(it.next().equals(o)) it.remove();  
        }
	}

	@Override
	public void update(Usuario o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedList<Usuario> listAll() {
		return usuarios;
	}
	
	
}
