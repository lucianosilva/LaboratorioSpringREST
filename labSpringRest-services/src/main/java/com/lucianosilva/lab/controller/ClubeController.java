/**
 * 
 */
package com.lucianosilva.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lucianosilva.lab.core.entity.Clube;
import com.lucianosilva.lab.service.ClubeService;

/**
 * @author luciano
 *
 */
@Controller
@RequestMapping("/clubeController")
public class ClubeController {

	@Autowired
	ClubeService clubeService;

	/**
	 * 
	 * @return
	 */
	public List<Clube> findAll(){
		//
		return clubeService.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Clube findById( @PathVariable("id") Long id ){
		//
		return clubeService.findById( id );
	}

}