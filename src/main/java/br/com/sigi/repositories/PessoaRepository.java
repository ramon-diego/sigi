package br.com.sigi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.Pessoa;
import java.lang.String;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	List<Pessoa> findByNomeFantasiaLikeOrCpfCnpjLike(String nomeFantasia, String cpfCnpj);
	List<Pessoa> findByNomeFantasiaLike(String nomefantasia);

}