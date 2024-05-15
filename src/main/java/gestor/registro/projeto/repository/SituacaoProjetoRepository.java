package gestor.registro.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestor.registro.lib.entity.SituacaoProjeto;

@Repository
public interface SituacaoProjetoRepository extends JpaRepository<SituacaoProjeto, Long>{

}
