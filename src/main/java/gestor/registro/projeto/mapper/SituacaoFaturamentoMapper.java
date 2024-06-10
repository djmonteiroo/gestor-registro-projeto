package gestor.registro.projeto.mapper;

import java.time.LocalDateTime;

import gestor.registro.lib.records.SituacaoFaturamentoRecord;
import org.springframework.stereotype.Component;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;
import gestor.registro.lib.entity.SituacaoFaturamentoProjeto;

@Component
public class SituacaoFaturamentoMapper {

	public SituacaoFaturamentoProjeto mapearSituacaoFaturamento(final SituacaoFaturamentoDto situacaoDto) {
		SituacaoFaturamentoProjeto situacao = new SituacaoFaturamentoProjeto();

		situacao.setNmSituacaoFaturamento(situacaoDto.getNmSituacaoFaturamento());
		situacao.setInAtivo(situacaoDto.getInAtivo());
		situacao.setDtInclusao(LocalDateTime.now());
		
		return situacao;
	}
}