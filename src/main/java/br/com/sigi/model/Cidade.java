package br.com.sigi.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.sigi.repositories.EntidadeBase;

//@Entity
@Table(name = "CIDADE")
public class Cidade implements Serializable, EntidadeBase {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_cidade")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 45, nullable = false)
	private String nome;

	@Enumerated(EnumType.STRING)
	@Column(length = 2, nullable = false)
	private Estado estado;

	@OneToMany(mappedBy = "cidade", cascade = CascadeType.ALL)
	private Set<Endereco> endereco = new HashSet<Endereco>();

	public Set<Endereco> getEndereco() {

		return endereco;
	}

	public void setEndereco(Set<Endereco> endereco) {
		this.endereco = endereco;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
