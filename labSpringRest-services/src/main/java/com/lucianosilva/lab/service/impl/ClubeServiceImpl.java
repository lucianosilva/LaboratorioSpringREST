/**
 * 
 */
package com.lucianosilva.lab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucianosilva.lab.service.ClubeService;
import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.core.repository.ClubeRepository;

/**
 * @author luciano
 *
 */
@Service("clubeService")
public class ClubeServiceImpl implements ClubeService {

	@Autowired
	ClubeRepository clubeRepo;

	/* (non-Javadoc)
	 * @see com.lucianosilva.lab.controller.ClubeController#findAll()
	 */
	@Override
	public List<Clube> findAll() {
		// 
		return clubeRepo.findAll();
	}

	@Override
	public Clube findById(Long id) {
		// 
		return clubeRepo.findById(id);
	}

}
