/**
 * 
 */
package com.lucianosilva.lab.service;

import java.util.List;

import com.lucianosilva.lab.core.entity.Clube;

/**
 * @author luciano
 *
 */
public interface ClubeService {

	/**
	 * 
	 * @return
	 */
	public List<Clube> findAll();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Clube findById( Long id );
}
