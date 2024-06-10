package gestor.registro.projeto.service.impl;

import static gestor.registro.lib.utils.GestaoProjetoUtils.getMensagem;
import static gestor.registro.lib.utils.GestaoProjetoUtils.toConvertReflection;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;
import gestor.registro.lib.entity.SituacaoProjeto;
import gestor.registro.lib.entity.SituacaoProjeto;
import gestor.registro.projeto.utils.GestorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestor.registro.lib.dto.SituacaoProjetoDto;
import gestor.registro.lib.entity.SituacaoProjeto;
import gestor.registro.lib.records.SituacaoProjetoRecord;
import gestor.registro.projeto.mapper.SituacaoMapper;
import gestor.registro.projeto.repository.SituacaoProjetoRepository;
import gestor.registro.projeto.service.SituacaoProjetoService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<SituacaoProjetoDto> listarSituacaProjeto() {
		List<SituacaoProjetoDto> lsSituacaoDto = new ArrayList<SituacaoProjetoDto>();
		List<SituacaoProjeto> lsSituacaoProjeto = situacaoRepository.findAll();

		lsSituacaoProjeto.forEach(situacao -> {
			SituacaoProjetoDto situacaoProjetoDto = toConvertReflection(situacao, SituacaoProjetoDto.class);

			situacaoProjetoDto.setDtInclusaoSaida(GestorUtils.tratamentoSaidaData(situacaoProjetoDto.getDtInclusao()));
			lsSituacaoDto.add(situacaoProjetoDto);
		});
		return lsSituacaoDto;
	}

	@Override
	public String desativarSituacaoProjeto(Long idSituacaoProjeto) {
		log.info(getMensagem("Desativando Status de Projeto para o id: ", idSituacaoProjeto));
		log.info("Buscando dados");
		SituacaoProjeto situacaoProjeto = situacaoRepository.findById(idSituacaoProjeto).get();
		situacaoProjeto.setInAtivo(0);
		log.info("Salvando atualizações");
		situacaoRepository.save(situacaoProjeto);
		return "Desativado com sucesso";
	}

	@Override
	public String ativarSituacaoProjeto(Long idSituacaoProjeto) {
		log.info(getMensagem("Desativando Status de Projeto para o id: ", idSituacaoProjeto));
		log.info("Buscando dados");
		SituacaoProjeto situacaoProjeto = situacaoRepository.findById(idSituacaoProjeto).get();
		situacaoProjeto.setInAtivo(1);
		log.info("Salvando atualizações");
		situacaoRepository.save(situacaoProjeto);
		return "Ativado com sucesso";
	}

}
