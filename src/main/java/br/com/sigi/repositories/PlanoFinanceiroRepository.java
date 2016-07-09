package br.com.sigi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.PlanoFinanceiro;


@Repository
public interface PlanoFinanceiroRepository extends JpaRepository<PlanoFinanceiro, Long> {
	
	List<PlanoFinanceiro> findById(Long id);

	@Query("select p from PlanoFinanceiro p where p.tipoTransacao = 'D' order by p.nome asc")
	List<PlanoFinanceiro> buscarPlanoDespesa();

	@Query("select p from PlanoFinanceiro p where p.tipoTransacao = 'R' order by p.nome asc")
	List<PlanoFinanceiro> buscarPlanoReceita();

	
}
