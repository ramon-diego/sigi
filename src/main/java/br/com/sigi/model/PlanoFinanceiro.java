package br.com.sigi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plano_financeiro")
public class PlanoFinanceiro implements Serializable {

	private static final long serialVersionUID = -8242139124371410891L;

	@Id
	@Column(name = "plano_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column (nullable = false, length = 55)
	private String nome;

	@Column(length = 1, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoTransacao tipoTransacao;

	public PlanoFinanceiro() {

	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	@Override
	public String toString() {
		return nome;
	}

}
