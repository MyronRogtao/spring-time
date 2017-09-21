package org.rest.base;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseRepository<E extends Serializable,ID> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<E> clazz;

	public E findById(ID id){
		
		return entityManager.find(clazz, id);
	}
	
	public E create(E entity){
		entityManager.persist(entity);
		return entity;
	}
	
	public E update(E entity){
		
		return entityManager.merge(entity);
	}
	
	public void delete(ID id){
		E entity = entityManager.find(clazz, id);
		entityManager.remove(entity);
	}
	
	public void delete(E entity){
		entityManager.remove(entity);
	}
	
}
