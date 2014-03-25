package infra;

import model.Cliente;


public abstract class ClienteDAOFactory implements DAO<Cliente>{
	
	public static final int CLIENTEARQUIVO = 1;
	public static final int CLIENTEMEMORIA = 2;
	
	
	public static ClienteDAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case CLIENTEARQUIVO: 
				return new ClienteArquivo() ;
			case CLIENTEMEMORIA: 
				return new ClienteMemoria();
			default: 
				return null;
    }
  }

}
