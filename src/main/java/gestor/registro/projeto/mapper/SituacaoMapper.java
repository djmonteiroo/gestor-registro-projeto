package gestor.registro.projeto.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import gestor.registro.lib.dto.SituacaoProjetoDto;
import gestor.registro.lib.entity.SituacaoProjeto;

@Component
public class SituacaoMapper {

	public SituacaoProjeto mapearSituacao(final SituacaoProjetoDto situacaoDto) {
		SituacaoProjeto situacao = new SituacaoProjeto();

		situacao.setNmSituacaoProjeto(situacaoDto.getNmSituacaoProjeto());
		situacao.setInAtivo(situacaoDto.getInAtivo());
		situacao.setDtInclusao(LocalDateTime.now());
		
		return situacao;
	}
}