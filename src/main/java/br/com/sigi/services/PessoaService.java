package br.com.sigi.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigi.model.Pessoa;
import br.com.sigi.repositories.PessoaRepository;

@Service
public class PessoaService implements Serializable {

	private static final long serialVersionUID = 2834973825384184184L;

	@Autowired
	private PessoaRepository pessoaRepository;

	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	public void save(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	public List<Pessoa> pesquisarPessoas(String nome, String cpfCnpj) {
		return pessoaRepository.findByNomeFantasiaLikeOrCpfCnpjLike(nome, cpfCnpj);
	}
	
	public List<Pessoa> pesquisarPorNome(String nome){
		return pessoaRepository.findByNomeFantasiaLike(nome);
	}
}