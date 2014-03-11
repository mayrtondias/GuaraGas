package infra;

import model.Funcionario;

public abstract class FuncionarioDAOFactory implements DAO<Funcionario>{

		public static final int FUNCIONARIOARQUIVO = 1;
		public static final int FUNCIONARIOMEMORIA = 2;

		
		
		public static FuncionarioDAOFactory getDAOFactory(int whichFactory) {
			switch (whichFactory) {
				case FUNCIONARIOARQUIVO: 
					return new FuncionarioArquivo() ;
				case FUNCIONARIOMEMORIA: 
					return new FuncionarioMemoria();
				default: 
					return null;
	    }
	  }

	}
