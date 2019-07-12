package tn.esprit.dao.inter;

import java.util.List;
import java.util.Optional;

public interface ObjectGenericDao <T,ID> {
	
	T find(ID id);
	List<T> findAll();
	int save (T o);
	boolean delete (T o);
	boolean update (T o);
	
	
}
