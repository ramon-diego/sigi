package br.com.sigi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {


	

}