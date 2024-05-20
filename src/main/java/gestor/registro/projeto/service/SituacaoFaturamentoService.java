package gestor.registro.projeto.service;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;
import org.springframework.stereotype.Component;

import gestor.registro.lib.records.SituacaoFaturamentoRecord;

import java.util.List;

@Component
public interface SituacaoFaturamentoService {

	public String registrarSituacaoFaturamento(final SituacaoFaturamentoRecord situacaoRecord);

    public List<SituacaoFaturamentoDto> listarSituacaoFaturamento();
}