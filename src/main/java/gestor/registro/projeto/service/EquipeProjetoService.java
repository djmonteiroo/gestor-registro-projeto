package gestor.registro.projeto.service;

import org.springframework.stereotype.Component;

import gestor.registro.lib.records.EquipeProjetoRecord;

@Component
public interface EquipeProjetoService {

	public String registrarEquipe(final EquipeProjetoRecord equipeRecord);

}
