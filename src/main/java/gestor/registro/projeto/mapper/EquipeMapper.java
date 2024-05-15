package gestor.registro.projeto.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import gestor.registro.lib.dto.EquipeProjetoDto;
import gestor.registro.lib.entity.EquipeProjeto;
import gestor.registro.lib.entity.ResponsavelProjeto;

@Component
public class EquipeMapper {

	public EquipeProjeto mapearEquipe(final EquipeProjetoDto equipeDto) {
		EquipeProjeto equipe = new EquipeProjeto();
		ResponsavelProjeto responsavelProjeto = new ResponsavelProjeto();
		responsavelProjeto.setIdResponsavelProjeto(equipeDto.getIdResponsavelProjeto());
		equipe.setResponsavelEquipe(responsavelProjeto);
		equipe.setNmEquipe(equipeDto.getNmEquipe());
		equipe.setInAtivo(1);
		equipe.setDtInclusao(LocalDateTime.now());
		
		return equipe;
	}
}