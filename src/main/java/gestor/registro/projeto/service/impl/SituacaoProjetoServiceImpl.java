package gestor.registro.projeto.service.impl;

import static gestor.registro.lib.utils.GestaoProjetoUtils.getMensagem;
import static gestor.registro.lib.utils.GestaoProjetoUtils.toConvertReflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestor.registro.lib.dto.SituacaoProjetoDto;
import gestor.registro.lib.entity.SituacaoProjeto;
import gestor.registro.lib.records.SituacaoProjetoRecord;
import gestor.registro.projeto.mapper.SituacaoMapper;
import gestor.registro.projeto.repository.SituacaoProjetoRepository;
import gestor.registro.projeto.service.SituacaoProjetoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SituacaoProjetoServiceImpl implements SituacaoProjetoService {

	@Autowired
	private SituacaoMapper situacaoMappper;
	
	@Autowired
	private SituacaoProjetoRepository situacaoRepository;
	
	@Override
	public String registrarSituacao(final SituacaoProjetoRecord situacaoRecord) {
		log.info(getMensagem("Realizado conversão de situacao: ", situacaoRecord.nmSituacaoProjeto()));
		SituacaoProjetoDto equipeDto = toConvertReflection(situacaoRecord, SituacaoProjetoDto.class);
		SituacaoProjeto equipe = situacaoMappper.mapearSituacao(equipeDto);
		situacaoRepository.save(equipe);
		
		return "Situacao Registrada com sucesso";
	}

}
