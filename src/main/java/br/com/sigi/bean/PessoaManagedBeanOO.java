package br.com.sigi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.sigi.dao.PessoaDAO;
import br.com.sigi.domain.Pessoa;

@ViewScoped
@ManagedBean(name = "pessoaBeans")
public class PessoaManagedBeanOO implements Serializable {

	private static final long serialVersionUID = 1L;

	private PessoaDAO pessoaDAO;
	private String filtro;
	private Pessoa pessoa;

	@SuppressWarnings("unused")
	private List<Pessoa> pessoas = new ArrayList<>();

	@PostConstruct
	public void init() {
		pessoaDAO = new PessoaDAO();
		pessoa = new Pessoa();
		
	}

	public List<Pessoa> getPessoas() {

		return pessoas = (pessoaDAO.buscarPorVariosAtributos(getFiltro()));

	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void listarPessoas() {
		getPessoas();
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}