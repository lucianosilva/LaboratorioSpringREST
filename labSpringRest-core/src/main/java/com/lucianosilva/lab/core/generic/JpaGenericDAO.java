/**
 * 
 */
package com.lucianosilva.lab.core.generic;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;

/**
 * @author luciano
 * 
 */
public abstract class JpaGenericDAO<T, ID extends Serializable> extends
	JpaDaoSupport implements GenericDAO<T, ID> {

	protected Class<T> entityClass;

	@Autowired
	@SuppressWarnings("unchecked")
	public JpaGenericDAO() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
	}

	@Override
	public void save(T entity)  {
		// 
		getJpaTemplate().persist( entity );
	}

	@Override
	public void update(T entity)  {
		// 
		getJpaTemplate().merge( entity );
	}

	@Override
	public void merge(T entity)  {
		// 
		getJpaTemplate().merge( entity );
	}

	@Override
	public void remove(T entity)  {
		// 
		getJpaTemplate().remove(entity);
	}

	@Override
	public List<T> findAll() {
		//
		Object res = getJpaTemplate().execute(new JpaCallback() {

			public Object doInJpa(EntityManager em) throws PersistenceException {
				Query q = em.createQuery("SELECT h FROM "
						+ entityClass.getName() + " h");
				return q.getResultList();
			}

		});

		return (List<T>) res;
	}

	@Override
	public T findById(ID id) {
		// 
		return getJpaTemplate().find(entityClass, id);
	}


}
