package br.com.sigi.domain;

import java.util.Date;

import br.com.sigi.dao.PessoaDAO;

public class PessoaTeste {

	public static void main(String[] args) {
			
		Pessoa pessoa = new Pessoa();
		PessoaDAO pessoaDAO = new PessoaDAO();
		Endereco endereco = new Endereco();
		Cidade cidade = new Cidade();
		Telefone fixo = new Telefone();
		fixo.setNumero("44 3023-5400");
				
		endereco.setNumero("872");
		endereco.setRua("Quintino Bocaiúva");
		
		endereco.setBairro("Zona 7");
		endereco.setComplemento("AP 15");
		
		cidade.setNome("Maringá");
		cidade.setEstado(Estado.PR);
		
		endereco.setCidade(cidade);
			
		pessoa.getEnderecos().add(endereco);
		pessoa.adicionarEndereco(endereco);
		
		pessoa.getTelefones().add(fixo);
		pessoa.adicionarTelefone(fixo);
				
		pessoa.setNomeFantasia("Ramon");
		pessoa.setCpfCnpj("12773148000298");
		pessoa.setRgIe("14.441.575-5");
		pessoa.setEmail("teste@hotmail.com");
		pessoa.setStatus(Status.A);
		pessoa.setSexo(Sexo.M);
		pessoa.setEstadoCivil(EstadoCivil.C);
		pessoa.setTipoPessoa(TipoPessoa.F);
		pessoa.setDataCadastro(new Date());
		pessoaDAO.salvar(pessoa);
		
	}
}
