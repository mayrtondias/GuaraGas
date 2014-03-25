package infra;

import java.util.LinkedList;

import excecoes.Excecoes;

public interface Command {
	
	public void exercute(Object c) throws Excecoes;
	
	public LinkedList lista();

}
