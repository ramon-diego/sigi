package br.com.sigi.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import br.com.sigi.dao.PessoaDAO;
import br.com.sigi.domain.Cidade;
import br.com.sigi.domain.Endereco;
import br.com.sigi.domain.Pessoa;
import br.com.sigi.domain.Telefone;

@ManagedBean(name = "pessoaBean")
@ViewScoped
public class PessoaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private Endereco endereco;
	private Cidade cidade;
	private Telefone telefone;
	private PessoaDAO pessoaDAO;
	private List<Pessoa> pessoas = new ArrayList<>();
	private String filtro;
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
		if (pessoa != null)
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

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}

	public List<Pessoa> getPessoas() {
		pessoaDAO = new PessoaDAO();
		return pessoas = (pessoaDAO.buscarPorVariosAtributos(getFiltro()));

	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public void listarPessoas() {
		getPessoas();
	}

	public void salvar() {
		pessoaDAO = new PessoaDAO();
		try {
			pessoa.setDataCadastro(new Date());
			pessoa.getEnderecos().add(endereco);
			pessoa.getTelefones().add(telefone);
			pessoa.adicionarEndereco(endereco);
			pessoa.adicionarTelefone(telefone);
			endereco.setCidade(cidade);
			pessoaDAO.salvar(pessoa);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void carregarPessoa(Long id) throws IOException {

		// HttpServletResponse response = (HttpServletResponse)
		// FacesContext.getCurrentInstance().getExternalContext()
		// .getFlash().put("id", pessoa);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro.xhtml");

		pessoaDAO = new PessoaDAO();
		pessoa = pessoaDAO.getById(id);
		System.out.println(pessoa.getId());
		System.out.println(pessoa.getNomeFantasia());

		// ExternalContext externalContext =
		// FacesContext.getCurrentInstance().getExternalContext().redirect("cadastro");

	}
	
	public String editar()
    {

        long id = Long.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));

        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoa", id);

        return "/cadastro?faces-redirect=true";
    }
	
	
}
