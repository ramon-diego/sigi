package br.com.sigi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.sigi.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {



}