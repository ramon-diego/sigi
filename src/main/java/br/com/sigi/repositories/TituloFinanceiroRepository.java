package br.com.sigi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.TituloFinanceiro;

@Repository
public interface TituloFinanceiroRepository
		extends JpaRepository<TituloFinanceiro, Long>, JpaSpecificationExecutor<TituloFinanceiro> {

}