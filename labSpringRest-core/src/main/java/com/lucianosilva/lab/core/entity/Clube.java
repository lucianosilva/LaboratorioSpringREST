/**
 *  Licença Creative Commons.
 *  Blog do Luciano Silva - www.lucianosilva.com
 */
package com.lucianosilva.lab.core.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 
 *
 * @autor luciano.silva
 * @version $Rev$ $Date$
 */

@XmlRootElement
@Cache (usage=CacheConcurrencyStrategy.TRANSACTIONAL)
@Entity
@Table( name = "TB_CLUBES" )
public class Clube implements BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1437475787538674983L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "ID_CLUBE", nullable = false)
	private Long idClube;

	@Column(name = "NOME", nullable = true)
	private String nome;

	@Column(name = "NOME_POP", nullable = true)
	private String nomePopular;

	@Temporal(TemporalType.DATE)
	@Column(name = "FUNDACAO", nullable = true)
	private Date dataFundacao;

	/**
	 * @return the idClube
	 */
	public Long getIdClube() {
		return idClube;
	}

	/**
	 * @param idClube the idClube to set
	 */
	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the nomePopular
	 */
	public String getNomePopular() {
		return nomePopular;
	}

	/**
	 * @param nomePopular the nomePopular to set
	 */
	public void setNomePopular(String nomePopular) {
		this.nomePopular = nomePopular;
	}

	/**
	 * @return the dataFundacao
	 */
	public Date getDataFundacao() {
		return dataFundacao;
	}

	/**
	 * @param dataFundacao the dataFundacao to set
	 */
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	@Override
	public Long getId() {
		// 
		return this.getIdClube();
	}

	@Override
	public void setId(Long id) {
		// 
		this.setIdClube(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}
}