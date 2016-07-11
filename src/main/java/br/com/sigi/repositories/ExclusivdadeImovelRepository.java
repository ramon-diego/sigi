package br.com.sigi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.ExclusividadeImovel;

@Repository
public interface ExclusivdadeImovelRepository extends JpaRepository<ExclusividadeImovel, Long>{

	
}