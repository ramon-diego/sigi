package br.com.sigi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


	List<Pessoa> findByNomeFantasiaContainingOrCpfCnpjContaining(String nome, String cpfCnpj);

}