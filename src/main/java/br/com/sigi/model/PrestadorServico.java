package br.com.sigi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "prestador_servico")
public class PrestadorServico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5730340903291623003L;

	public PrestadorServico() {

	}

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "prestador_id")
	private Long id;

	private String descricao;

	private Pessoa prestador;

	@Column(length = 40, nullable = false)
	private String categoria;

}
