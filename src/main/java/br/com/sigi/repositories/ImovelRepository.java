package br.com.sigi.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.sigi.model.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>, JpaSpecificationExecutor<Imovel> {

	
	@Query("select i from Imovel i where i.finalidade = :finalidade and i.tipoImovel = :tipoImovel and i.id = :id")
	List<Imovel> pesquisarImovel(@Param("finalidade") String finalidade, @Param("tipoImovel") String tipoImovel,
			@Param("id") Long id);
}