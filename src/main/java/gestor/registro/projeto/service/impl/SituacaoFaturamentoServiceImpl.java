package gestor.registro.projeto.service.impl;

import static gestor.registro.lib.utils.GestaoProjetoUtils.getMensagem;
import static gestor.registro.lib.utils.GestaoProjetoUtils.toConvertReflection;

import gestor.registro.projeto.utils.GestorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;
import gestor.registro.lib.entity.SituacaoFaturamentoProjeto;
import gestor.registro.lib.records.SituacaoFaturamentoRecord;
import gestor.registro.projeto.mapper.SituacaoFaturamentoMapper;
import gestor.registro.projeto.repository.SituacaoFaturamentoProjetoRepository;
import gestor.registro.projeto.service.SituacaoFaturamentoService;
import lombok.extern.slf4j.Slf4j;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<SituacaoFaturamentoDto> listarSituacaoFaturamento() {
		List<SituacaoFaturamentoDto> lsSituacaoDto = new ArrayList<SituacaoFaturamentoDto>();
		List<SituacaoFaturamentoProjeto> lsSituacaoFaturamento = situacaoRepository.findAll();

		lsSituacaoFaturamento.forEach(situacao -> {
			SituacaoFaturamentoDto situacaoFaturamento = toConvertReflection(situacao, SituacaoFaturamentoDto.class);
			situacaoFaturamento.setDtInclusaoSaida(GestorUtils.tratamentoSaidaData(situacaoFaturamento.getDtInclusao()));
			lsSituacaoDto.add(situacaoFaturamento);
		});
		return lsSituacaoDto;
	}
	@Override
	public String desativarSituacaoFaturamento(Long idLSituacaoFaturamento) {
		log.info(getMensagem("Desativando Status de Faturamento para o id: ", idLSituacaoFaturamento));
		log.info("Buscando dados");
		SituacaoFaturamentoProjeto situacaoFaturamentoProjeto = situacaoRepository.findById(idLSituacaoFaturamento).get();
		situacaoFaturamentoProjeto.setInAtivo(0);
		log.info("Salvando atualizações");
		situacaoRepository.save(situacaoFaturamentoProjeto);
		return "Desativado com sucesso";
	}

	@Override
	public String ativarSituacaoFaturamento(Long idLSituacaoFaturamento) {
		log.info(getMensagem("Ativando Status de Faturamento para o id: ", idLSituacaoFaturamento));
		log.info("Buscando dados");
		SituacaoFaturamentoProjeto situacaoFaturamentoProjeto = situacaoRepository.findById(idLSituacaoFaturamento).get();
		situacaoFaturamentoProjeto.setInAtivo(1);
		log.info("Salvando atualizações");
		situacaoRepository.save(situacaoFaturamentoProjeto);
		return "Ativado com sucesso";
	}



}
