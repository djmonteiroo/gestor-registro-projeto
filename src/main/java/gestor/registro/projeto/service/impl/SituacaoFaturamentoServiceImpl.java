package gestor.registro.projeto.service.impl;

import static gestor.registro.lib.utils.GestaoProjetoUtils.getMensagem;
import static gestor.registro.lib.utils.GestaoProjetoUtils.toConvertReflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;
import gestor.registro.lib.entity.SituacaoFaturamentoProjeto;
import gestor.registro.lib.records.SituacaoFaturamentoRecord;
import gestor.registro.projeto.mapper.SituacaoFaturamentoMapper;
import gestor.registro.projeto.repository.SituacaoFaturamentoProjetoRepository;
import gestor.registro.projeto.service.SituacaoFaturamentoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SituacaoFaturamentoServiceImpl implements SituacaoFaturamentoService {

	@Autowired
	private SituacaoFaturamentoMapper situacaoFaturamentoMappper;
	
	@Autowired
	private SituacaoFaturamentoProjetoRepository situacaoRepository;
	
	@Override
	public String registrarSituacaoFaturamento(final SituacaoFaturamentoRecord situacaoRecord) {
		log.info(getMensagem("Realizado conversão de situacao: ", situacaoRecord.nmSituacaoFaturamento()));
		SituacaoFaturamentoDto situacaoFaturamentoDto = toConvertReflection(situacaoRecord, SituacaoFaturamentoDto.class);
		SituacaoFaturamentoProjeto situacaoFaturamento = situacaoFaturamentoMappper.mapearSituacaoFaturamento(situacaoFaturamentoDto);
		situacaoRepository.save(situacaoFaturamento);
		
		return "Situacao Registrada com sucesso";
	}

}
