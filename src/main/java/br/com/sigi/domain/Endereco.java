package br.com.sigi.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, nullable = false)
	private String rua;

	@Column
	private Long numero;

	@Column(length = 45)
	private String complemento;

	@Column(length = 45)
	private String bairro;

	@Column(length = 8)
	private String cep;

	@JoinColumn(nullable = false, name = "fk_end_cidade")
	@ManyToOne(cascade = CascadeType.ALL)
	private Cidade cidade;

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}