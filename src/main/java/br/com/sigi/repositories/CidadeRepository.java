package br.com.sigi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sigi.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
	Cidade findByNome(String nome);
}
