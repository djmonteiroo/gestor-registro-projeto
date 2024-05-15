package gestor.registro.projeto.service;

import org.springframework.stereotype.Component;

import gestor.registro.lib.records.SituacaoProjetoRecord;

@Component
public interface SituacaoProjetoService {

	public String registrarSituacao(final SituacaoProjetoRecord situacaoProjetoRecord);

}
