/**
 * 
 */
package com.lucianosilva.lab.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Clube findById(@PathVariable("id") Long id) throws Exception {
		//
		return clubeService.findById(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET )
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public ResponseEntity<String> remove( @PathVariable("id") Long id ) throws Exception {
		//
		HttpHeaders headers = new HttpHeaders();
	    headers.add("Content-Type", "application/json");

		// Procura pelo ID que deve ser removido
		Clube clube = clubeService.findById( id );
		if( clube == null ){
			return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
		}

		// Remove...
		clubeService.remove(clube);

		return new ResponseEntity<String>(headers, HttpStatus.OK); 
	}

	/**
	 * 
	 * @param clube
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveUsingJson", headers = "Accept=application/json", method = RequestMethod.POST )
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@ResponseBody
	public Clube saveClube( @RequestBody Clube clube ) throws Exception {

		clubeService.save( clube );
		//
		return clubeService.findById(clube.getIdClube());
	}

	/**
	 * 
	 * @param nome
	 * @param nomePopular
	 * @param dataFundacao
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save/{nome}/{nomePopular}/{dataFundacao}", method = RequestMethod.PUT)
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	@ResponseBody
	public Clube saveClube(	@PathVariable("nome") String nome,
							@PathVariable("nomePopular") String nomePopular,
							@PathVariable("dataFundacao") String dataFundacao ) throws Exception {

		//
		Clube clube = new Clube();
		clube.setNome(nome);
		clube.setNomePopular(nomePopular);

		// Convertendo de String para java.util.Date
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		Date dtFund = (Date) df.parse(dataFundacao);

		clube.setDataFundacao(dtFund);

		//
		clubeService.save( clube );
		//
		return clubeService.findById( clube.getIdClube() );
	}

}