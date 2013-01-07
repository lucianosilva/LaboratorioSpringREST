/**
 * 
 */
package com.lucianosilva.lab.core.entity;

import java.io.Serializable;

/**
 * @author luciano
 *
 */
public interface BaseEntity<T> extends Serializable {

	/**
	 * 
	 * @return
	 */
	T getId();
	
	/**
	 * 
	 * @param id
	 */
	void setId( T id );
}
