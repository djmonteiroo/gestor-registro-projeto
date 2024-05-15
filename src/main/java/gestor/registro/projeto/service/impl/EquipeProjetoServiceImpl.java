package gestor.registro.projeto.service.impl;

import gestor.registro.lib.dto.EquipeProjetoDto;
import gestor.registro.lib.entity.EquipeProjeto;
import gestor.registro.lib.records.EquipeProjetoRecord;
import gestor.registro.projeto.mapper.EquipeMapper;
import gestor.registro.projeto.repository.EquipeProjetoRepository;
import gestor.registro.projeto.service.EquipeProjetoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static gestor.registro.lib.utils.GestaoProjetoUtils.getMensagem;
import static gestor.registro.lib.utils.GestaoProjetoUtils.toConvertReflection;

@Service
@Slf4j
public class EquipeProjetoServiceImpl implements EquipeProjetoService {

	@Autowired
	private EquipeMapper equipeMapper;
	
	@Autowired
	private EquipeProjetoRepository equipeRepository;
	
	@Override
	public String registrarEquipe(final EquipeProjetoRecord equipeRecord) {
		log.info(getMensagem("Realizado conversão de equipe: ", equipeRecord.nmEquipe()));
		EquipeProjetoDto equipeDto = toConvertReflection(equipeRecord, EquipeProjetoDto.class);
		EquipeProjeto equipe = equipeMapper.mapearEquipe(equipeDto);
		equipeRepository.save(equipe);
		
		
		return "Equipe Registrada com sucesso";
	}

}
