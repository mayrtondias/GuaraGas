package infra;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import model.Cliente;

public class ClienteArquivo extends ClienteDAOFactory {
	
	private Path path = null;
	private Charset utf8 =  null;
	
	public ClienteArquivo(){
		path = Paths.get("");
		utf8 = StandardCharsets.UTF_8;
		
	}

	@Override
	public Cliente get(String pesquisa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Cliente o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cliente o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LinkedList<Cliente> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
