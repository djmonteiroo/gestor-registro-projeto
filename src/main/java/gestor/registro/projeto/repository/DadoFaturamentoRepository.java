package gestor.registro.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestor.registro.lib.entity.DadoFaturamento;

@Repository
public interface DadoFaturamentoRepository extends JpaRepository<DadoFaturamento, Long>{

}
