package org.rest.base;

import java.io.Serializable;

public interface GenericRepository<E extends Serializable,ID > {

	E findById(ID id);
	
	E create(E entity);
	
	E update(E entity);
	
	void delete(ID id);
	
	void delete(E entity);
}
