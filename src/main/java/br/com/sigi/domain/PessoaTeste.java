package br.com.sigi.domain;

import br.com.sigi.dao.PessoaDAO;

public class PessoaTeste {

	public static void main(String[] args) {
	
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Endereco endereco = new Endereco();
		Cidade cidade = new Cidade();
		
		pessoa.setNomeFantasia("Ramon");
		pessoa.setCpfCnpj("099.189.355-55");
		pessoa.setRgIe("12.545-56");
		pessoa.setEmail("ramon@gmail.com");
		pessoa.setStatus(Status.A);
		pessoa.setSexo(Sexo.M);
		pessoa.setEstadoCivil(EstadoCivil.C);
		pessoa.setTipoPessoa(TipoPessoa.F);
		endereco.setRua("Quintino Bocaiúva 5454");
		
		endereco.setComplemento("AP 15");
		endereco.setBairro("Zona 07");
		pessoa.setEndereco(endereco);		
		endereco.setCidade(cidade);
		pessoaDAO.salvar(pessoa);
		
	}

}
