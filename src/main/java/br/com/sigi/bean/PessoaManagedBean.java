package br.com.sigi.bean;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.sigi.domain.Pessoa;

@ManagedBean
@RequestScoped
public class PessoaManagedBean implements Serializable{


	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
