/**
 *  Licença Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.core.repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.core.generic.JpaGenericDAO;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */
@Repository("clubeRepository")
public class ClubeRepository extends JpaGenericDAO<Clube, Long> {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@PostConstruct
	public void init() {
		super.setEntityManagerFactory(entityManagerFactory);
	}


}