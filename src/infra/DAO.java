package infra;

import java.util.LinkedList;

public interface DAO<O> {
	
	O get(String pes);

	void add(O o);

	void delete(O o);

	void update(O o);
	
	LinkedList<O> listAll();
	
}
