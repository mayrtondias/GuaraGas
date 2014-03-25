package infra;

import java.util.Iterator;
import java.util.LinkedList;

public class Interador<T> implements Iterator<T>{
	
	private LinkedList<T> lista;
	private static int indexAtual=0;
	
	public Interador (LinkedList<T>  list){
		lista=list;
		indexAtual=0;
	}

	@Override
	public boolean hasNext() {
		if(indexAtual<lista.size()){
			return true;
		}
		return false;
	}

	@Override
	public T next() {
		T n =lista.get(indexAtual);
		++indexAtual;
		return n;
	}

	@Override
	public void remove() {
		lista.remove(indexAtual);
		
	}

}
