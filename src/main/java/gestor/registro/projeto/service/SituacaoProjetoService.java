package gestor.registro.projeto.service;

import gestor.registro.lib.dto.SituacaoProjetoDto;
import org.springframework.stereotype.Component;

import gestor.registro.lib.records.SituacaoProjetoRecord;

import java.util.List;

@Component
public interface SituacaoProjetoService {

	public String registrarSituacao(final SituacaoProjetoRecord situacaoProjetoRecord);

	public List<SituacaoProjetoDto> listarSituacaProjeto();

	String desativarSituacaoProjeto(Long idSituacaoProjeto);

	String ativarSituacaoProjeto(Long idSituacaoProjeto);
}
