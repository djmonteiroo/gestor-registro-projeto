package gestor.registro.projeto.service.impl;

import static gestor.registro.lib.utils.GestaoProjetoUtils.getMensagem;
import static gestor.registro.lib.utils.GestaoProjetoUtils.toConvertReflection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestor.registro.lib.dto.ProjetoDTO;
import gestor.registro.lib.entity.DadoFaturamento;
import gestor.registro.lib.entity.Projeto;
import gestor.registro.lib.records.RegistroProjetoRecord;
import gestor.registro.projeto.mapper.DadoFaturamentoMapper;
import gestor.registro.projeto.mapper.ProjetoMapper;
import gestor.registro.projeto.repository.DadoFaturamentoRepository;
import gestor.registro.projeto.repository.RegistroProjetoRepository;
import gestor.registro.projeto.service.RegistroProjetoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistroProjetoServiceImpl implements RegistroProjetoService {

	@Autowired
	private ProjetoMapper projetoMapper;
	
	@Autowired
	private RegistroProjetoRepository registroProjetoRepository;
	
	@Autowired
	private DadoFaturamentoMapper faturamentoMapper;
	
	@Autowired
	private DadoFaturamentoRepository dadoFaturamentoRepository;
	
	@Override
	public String registrarNovoProjeto(final RegistroProjetoRecord projetoRecord) {
		try {
			log.info("Realizando conversão para DTO.");
			ProjetoDTO novoProjetoDto = toConvertReflection(projetoRecord, ProjetoDTO.class);
			log.info(getMensagem("Iniciando registro do projeto: ", novoProjetoDto.getTitulo()));
			
			log.info(getMensagem("Convertendo DTO para Entidade"));
			Projeto novoProjeto = projetoMapper.mapearProjeto(novoProjetoDto);
			registroProjetoRepository.save(novoProjeto);
			
			log.info("Mapeando dados de Faturamento.");
			DadoFaturamento dadoFaturamento = faturamentoMapper.mapearFaturamento(novoProjetoDto, novoProjeto.getIdProjeto());
			dadoFaturamentoRepository.save(dadoFaturamento);

		} catch (Exception e) {
			throw new RuntimeException(getMensagem("Erro ao realizar operação: ", e.getMessage()));
		}
		
		return "Projeto cadastrado com Sucesso";
	}

}