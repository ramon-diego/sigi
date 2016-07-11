package br.com.sigi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.VistoriaImovel;

@Repository
public interface VistoriaImovelRepository extends JpaRepository<VistoriaImovel, Long> {

	

}