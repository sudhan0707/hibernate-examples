package org.examples.integration.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDAO<T extends Serializable> implements GenericDAO{

	 private Class< T > clazz;
	 
	 @Autowired
	 private SessionFactory sessionFactory;
	 
	 public void setClazz(Class<T> clazz) {
			this.clazz = clazz;
		}
	 
	public T findOne(long id) {
		return (T) getCurrentSession().get(clazz, id);
	}

	public List<T> findAll() {
		return getCurrentSession().createQuery("From" +clazz.getName()).list();
	}

	public T save(Serializable entity) {
		return (T) getCurrentSession().save(entity);
	}

	public T update(Serializable entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(Serializable entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(long id) {
		T entity = findOne(id);
		delete(entity);
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
