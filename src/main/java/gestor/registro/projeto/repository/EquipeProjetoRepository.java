package gestor.registro.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestor.registro.lib.entity.EquipeProjeto;

@Repository
public interface EquipeProjetoRepository extends JpaRepository<EquipeProjeto, Long>{

}
