package br.com.sigi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import org.hibernate.service.spi.InjectService;

import br.com.sigi.dao.PessoaDAO;
import br.com.sigi.domain.Cidade;
import br.com.sigi.domain.Endereco;
import br.com.sigi.domain.Pessoa;
import br.com.sigi.domain.Telefone;
import br.com.sigi.domain.TipoPessoa;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Endereco endereco;
	private Cidade cidade;
	Telefone celular;
	Telefone residencial;
	Telefone comercial;
	private PessoaDAO pessoaDAO;
	@SuppressWarnings("unused")
	private List<Pessoa> pessoas = new ArrayList<>();
	private String buscaNome;
	private String buscaCpfCnpj;
	private Long buscaId;
	private boolean renderFisica = true;
	private boolean renderJuridica = false;

	@PostConstruct
	public void init() {

		pessoa = new Pessoa();
		endereco = new Endereco();
		celular = new Telefone();
		residencial = new Telefone();
		comercial = new Telefone();
		cidade = new Cidade();
		pessoas = null;
	}

	public void setRenderFisica(boolean renderFisica) {
		this.renderFisica = renderFisica;
		renderJuridica = false;
	}

	public void setRenderJuridica(boolean renderJuridica) {
		this.renderJuridica = renderJuridica;
		renderFisica = false;
	}

	public boolean isRenderFisica() {
		return renderFisica;
	}

	public boolean isRenderJuridica() {
		return renderJuridica;
	}

	public Pessoa getPessoa() {
		if (pessoa == null) {
			pessoa = new Pessoa();
		}
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		if (endereco == null) {
			endereco = new Endereco();
		}
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getCelular() {
		if (celular == null) {
			celular = new Telefone();
		}
		return celular;
	}

	public Telefone getComercial() {
		if (comercial == null) {
			comercial = new Telefone();
		}
		return comercial;
	}

	public Telefone getResidencial() {
		if (residencial == null) {
			residencial = new Telefone();
		}
		return residencial;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Cidade getCidade() {
		if (cidade == null) {
			cidade = new Cidade();
		}
		return cidade;
	}

	public List<Pessoa> getPessoas() {
		pessoaDAO = new PessoaDAO();
		return pessoas = (pessoaDAO.buscarPorVariosAtributos(getBuscaNome(), getBuscaCpfCnpj()));
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void listarPessoas() {
		getPessoas();
	}

	public void setBuscaCpfCnpj(String buscaCpfCnpj) {
		this.buscaCpfCnpj = buscaCpfCnpj;
	}

	public String getBuscaCpfCnpj() {
		return buscaCpfCnpj;
	}

	public void setBuscaId(Long buscaId) {
		this.buscaId = buscaId;
	}

	public Long getBuscaId() {
		return buscaId;
	}

	public void setBuscaNome(String buscaNome) {
		this.buscaNome = buscaNome;
	}

	public String getBuscaNome() {
		return buscaNome;
	}

	public void verificarTelefones() {

		if (!celular.getNumero().isEmpty()) {
			pessoa.getTelefones().add(celular);
			pessoa.adicionarTelefone(celular);
		}

		if (!residencial.getNumero().isEmpty()) {
			pessoa.getTelefones().add(residencial);
			pessoa.adicionarTelefone(residencial);
		}
		if (!comercial.getNumero().isEmpty()) {
			pessoa.getTelefones().add(comercial);
			pessoa.adicionarTelefone(comercial);
		}
	}
	//
	// public void preparaObjeto() {
	//
	// pessoa.getCpfCnpj().replaceAll("[-.]", "");
	// celular.getNumero().replaceAll("[() ]", "");
	// comercial.getNumero().replaceAll("[() ]", "");
	// residencial.getNumero().replaceAll("[() ]", "");
	// endereco.getCep().replace("[-]", "");
	// }

	public void salvar() {

		pessoaDAO = new PessoaDAO();

		try {
			pessoa.setDataCadastro(new Date());
			// preparaObjeto();
			pessoa.getEnderecos().add(endereco);

			verificarTelefones();
			pessoa.adicionarEndereco(endereco);
			endereco.setCidade(cidade);
			pessoaDAO.salvar(pessoa);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
