package infra;

import model.Usuario;

public abstract class UsuarioDAOFactory implements DAO<Usuario>{
	public static final int USUARIOARQUIVO = 1;
	public static final int USUARIOMEMORIA = 2;
	
	
	public static UsuarioDAOFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case USUARIOARQUIVO: 
				return new UsuarioArquivo() ;
			case USUARIOMEMORIA: 
				return new UsuarioMemoria();
			default: 
				return null;
    }
  }

}