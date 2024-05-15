package gestor.registro.projeto.service;

import org.springframework.stereotype.Component;

import gestor.registro.lib.records.SituacaoFaturamentoRecord;

@Component
public interface SituacaoFaturamentoService {

	public String registrarSituacaoFaturamento(final SituacaoFaturamentoRecord situacaoRecord);

}