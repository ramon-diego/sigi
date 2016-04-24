package br.com.sigi.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.sun.faces.action.RequestMapping;

import br.com.sigi.dao.PessoaDAO;
import br.com.sigi.domain.Cidade;
import br.com.sigi.domain.Endereco;
import br.com.sigi.domain.Pessoa;
import br.com.sigi.domain.Telefone;

@ManagedBean
@RequestMapping
public class CadastroPessoaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Endereco endereco;
	private Cidade cidade;
	private Telefone telefone;
	private boolean isFisica = true;;
	private boolean isJuridica = false;

	public boolean isFisica() {
		return isFisica;
	}

	public void setFisica(boolean isFisica) {
		this.isFisica = isFisica;
		isJuridica = false;
	}

	public boolean isJuridica() {
		return isJuridica;
	}

	public void setJuridica(boolean isJuridica) {
		this.isJuridica = isJuridica;
		isFisica = false;
	}

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		endereco = new Endereco();
		telefone = new Telefone();
		cidade = new Cidade();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void salvar() {

		try {
			if (pessoa.getId()!= null) {
				PessoaDAO pessoaDAO = new PessoaDAO();
				pessoa = pessoaDAO.getById(pessoa.getId());
				pessoaDAO.update(pessoa);
				

			} else {
				PessoaDAO pessoaDAO = new PessoaDAO();
				pessoa.setDataCadastro(new Date());
				pessoa.getEnderecos().add(endereco);
				pessoa.getTelefones().add(telefone);
				pessoa.adicionarEndereco(endereco);
				pessoa.adicionarTelefone(telefone);
				endereco.setCidade(cidade);
				pessoaDAO.salvar(pessoa);
			}

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void excluir() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.getById(pessoa.getId());
		pessoaDAO.update(pessoa);
	}
}
