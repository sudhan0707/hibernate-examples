package org.examples.integration.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO <T extends Serializable>{

	T findOne (final long id);
	
	List<T> findAll();
	
	T save (final T entity);
	
	T update (final T entity);
	
	void delete (final T entity);
	
	void deleteById (final long id);

}
