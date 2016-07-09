package br.com.sigi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.sigi.model.Pessoa;

public interface CorretorRepository extends JpaRepository<Pessoa, Long> {

	@Query("select c from Pessoa c where c.isCorretor = 1")
	List<Pessoa> pesquisarCorretor();
}
