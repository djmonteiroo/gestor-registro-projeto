package gestor.registro.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gestor.registro.lib.entity.ResponsavelProjeto;

@Repository
public interface ResponsavelProjetoRepository extends JpaRepository<ResponsavelProjeto, Long>{

}
