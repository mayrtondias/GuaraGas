package infra;

import model.Cliente;

//Padrao para instaciacao do DAO

public abstract class DAOFactory implements DAO<Cliente>{
	
	public static final int CLIENTEARQUIVO = 1;
	public static final int CLIENTEMEMORIA = 2;
	public static final int FUNCIONARIOARQUIVO = 3;
	public static final int FUNCIONARIOMEMORIA = 4;
	public static final int USUARIOARQUIVO = 5;
	public static final int USUARIOMEMORIA = 6;
	
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case CLIENTEARQUIVO: 
				return new ClienteArquivo() ;
			case CLIENTEMEMORIA: 
				return new ClienteMemoria();
			case FUNCIONARIOARQUIVO: 
				return new ClienteArquivo() ;
			case FUNCIONARIOMEMORIA: 
				return new ClienteMemoria();
			case USUARIOARQUIVO: 
				return new ClienteArquivo() ;
			case USUARIOMEMORIA: 
				return new ClienteMemoria();
			default: 
				return null;
    }
  }

}
