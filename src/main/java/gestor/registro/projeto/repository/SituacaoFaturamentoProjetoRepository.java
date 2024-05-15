package gestor.registro.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestor.registro.lib.entity.SituacaoFaturamentoProjeto;

@Repository
public interface SituacaoFaturamentoProjetoRepository extends JpaRepository<SituacaoFaturamentoProjeto, Long>{

}
