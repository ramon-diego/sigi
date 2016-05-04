package br.com.sigi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class Email implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_email")
	private Long id;

	private String endereco;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
