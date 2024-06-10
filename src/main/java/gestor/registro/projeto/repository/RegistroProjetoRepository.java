package gestor.registro.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestor.registro.lib.entity.Projeto;

@Repository
public interface RegistroProjetoRepository extends JpaRepository<Projeto, Long>{

}
