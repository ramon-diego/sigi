package br.com.sigi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigi.model.Endereco;


public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	Endereco findById(Long id);
}
