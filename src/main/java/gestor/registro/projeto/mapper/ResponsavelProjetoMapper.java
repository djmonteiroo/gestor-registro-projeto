package gestor.registro.projeto.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import gestor.registro.lib.dto.ResposavelProjetoDto;

@Component
public class ResponsavelProjetoMapper {

	public ResposavelProjetoDto responsavelProjetoDto(final ResposavelProjetoDto responsaveProjetoDto) {
		new ResposavelProjetoDto();
		return ResposavelProjetoDto
		    			.builder()
		    			.nmResponsavelProjeto(responsaveProjetoDto.getNmResponsavelProjeto())
		    			.inAtivo(1)
		    			.dtInclusao(LocalDateTime.now())
		    			.build();
	}
}
