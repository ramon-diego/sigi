package br.com.sigi.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.sigi.repositories.EntidadeBase;

//@Entity
@Table(name = "ENDERECO")
public class Endereco implements Serializable, EntidadeBase {

	private static final long serialVersionUID = 1L;

	public Endereco() {

	}

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60)
	private String rua;

	@Column
	private String numero;

	@Column(length = 45)
	private String complemento;

	@Column(length = 45)
	private String bairro;

	@Column(length = 8)
	private String cep;

	@ManyToOne(cascade = CascadeType.ALL)
	private Cidade cidade;

	@ManyToOne
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	@Override
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	
	@Override
	public String toString() {

		return "Endereco [id=" + id + ", rua=" + rua + ", numero=" + numero + ", bairro="
				+ bairro + ", cep=" + cep + ", complemento=" + complemento + ", cidade=" + cidade + "]";
		
	}
}
