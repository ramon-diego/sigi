package br.com.sigi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query("select p from Pessoa p where p.nomeFantasia like %:nome% or p.cpfCnpj like %:cpfCnpj%")
	List<Pessoa> pesquisarPessoas(@Param("nome") String nome, @Param("cpfCnpj") String cpfCnpj);
	
	
	@Query("select p from Pessoa p where p.nomeFantasia like %:nome% and p.cpfCnpj like %:cpfCnpj% and p.isProprietario = 1")
	List<Pessoa> pesquisarProprietario(@Param("nome") String nome, @Param("cpfCnpj") String cpfCnpj);

	
	@Query("select p from Pessoa p where p.nomeFantasia like %:nome% and p.cpfCnpj like %:cpfCnpj%")
	List<Pessoa> pesquisarPessoaTitulo(@Param("nome") String nome, @Param("cpfCnpj") String cpfCnpj);
	
	
	@Query("select p from Pessoa p where p.nomeFantasia like %:nome% and p.isCorretor = 1")
	List<Pessoa> pesquisarAngariador(@Param("nome") String nome);
	
	Pessoa findById(Long id);
}