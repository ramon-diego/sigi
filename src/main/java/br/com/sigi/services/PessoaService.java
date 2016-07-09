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
		return pessoaRepository.pesquisarPessoas(nome, cpfCnpj);
	}

	public List<Pessoa> pesquisarProprietario(String nome, String cpfCnpj) {
//		if (!nome.isEmpty() || !cpfCnpj.isEmpty()) {
//		}
//		return null;
	return pessoaRepository.pesquisarProprietario(nome, cpfCnpj);
	}
	
	public List<Pessoa> pesquisarPessoaTitulo(String nome, String cpfCnpj) {
//		if (!nome.isEmpty() || !cpfCnpj.isEmpty()) {
//		}
//		return null;
		return pessoaRepository.pesquisarPessoaTitulo(nome, cpfCnpj);
	}
	

	public List<Pessoa> pesquisarAngariador(String nome) {
			return pessoaRepository.pesquisarAngariador(nome);		
	}
	
	public Pessoa delete(Long id){
		return pessoaRepository.findOne(id);
	}
	
	public Pessoa pesquisarPorId(Long id){
		return pessoaRepository.findById(id);
	}
}