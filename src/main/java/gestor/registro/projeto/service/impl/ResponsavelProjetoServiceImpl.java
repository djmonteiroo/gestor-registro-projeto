package gestor.registro.projeto.service.impl;

import static gestor.registro.lib.utils.GestaoProjetoUtils.getMensagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestor.registro.lib.dto.ResposavelProjetoDto;
import gestor.registro.lib.entity.ResponsavelProjeto;
import gestor.registro.lib.records.ResponsavelProjetoRecord;
import gestor.registro.lib.utils.GestaoProjetoUtils;
import gestor.registro.projeto.mapper.ResponsavelProjetoMapper;
import gestor.registro.projeto.repository.ResponsavelProjetoRepository;
import gestor.registro.projeto.service.ResponsavelProjetoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResponsavelProjetoServiceImpl implements ResponsavelProjetoService {

	@Autowired
	private ResponsavelProjetoMapper responsavelMapper;
	
	@Autowired
	private ResponsavelProjetoRepository responsavelRepository;
	
	@Override
	public String registrarResponsavel(final ResponsavelProjetoRecord responsavelRecord) throws Exception {
		
		try {
			log.info(getMensagem("Realizando conversão para o usuario: ", responsavelRecord.nmResponsavelProjeto() ));
			ResposavelProjetoDto responsaveProjetoDto = GestaoProjetoUtils.toConvertReflection(responsavelRecord, ResposavelProjetoDto.class);
			
			log.info(getMensagem("Realizando mapeamento de dados"));
			ResposavelProjetoDto responsavelProjetoDto = responsavelMapper.responsavelProjetoDto(responsaveProjetoDto);
			
			log.info("Convertendo Objecto para entity.");
			ResponsavelProjeto responsavel = GestaoProjetoUtils.toConvertReflection(responsavelProjetoDto, ResponsavelProjeto.class);
			
			responsavelRepository.save(responsavel);
			
		} catch (Exception e) {
			throw new Exception(getMensagem("Erro ao realizar operação", e.getMessage()));
		}
		return "Registro realizado com sucesso";
	}

}
