package gestor.registro.projeto.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import gestor.registro.lib.dto.ProjetoDTO;
import gestor.registro.lib.entity.DadoFaturamento;
import gestor.registro.lib.entity.Projeto;

@Component
public class DadoFaturamentoMapper {
    
	public DadoFaturamento mapearFaturamento(final ProjetoDTO dto, final Long idProjeto) {
		DadoFaturamento dadoFaturamento = new DadoFaturamento();
		
		dadoFaturamento.setValorTotalFaturamento(dto.getValorTotalFaturamento());
		dadoFaturamento.setQtParcela(dto.getQtParcela());
		dadoFaturamento.setAnoMesReferenciaFaturamento(dto.getAnoMesReferenciaFaturamento());
		dadoFaturamento.setInAtivo(1);
		dadoFaturamento.setDtInclusao(LocalDateTime.now());
		
		Projeto projeto = new Projeto();
		projeto.setIdProjeto(idProjeto);
		dadoFaturamento.setProjeto(projeto);
		return dadoFaturamento;
	}

}
