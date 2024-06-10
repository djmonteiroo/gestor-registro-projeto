package gestor.registro.projeto.mapper;

import org.springframework.stereotype.Component;

import gestor.registro.lib.dto.ProjetoDTO;
import gestor.registro.lib.entity.EquipeProjeto;
import gestor.registro.lib.entity.Projeto;
import gestor.registro.lib.entity.Colaborador;
import gestor.registro.lib.entity.SituacaoFaturamentoProjeto;
import gestor.registro.lib.entity.SituacaoProjeto;

@Component
public class ProjetoMapper {
	
	public Projeto mapearProjeto(final ProjetoDTO dto) {
		Projeto projeto = new Projeto();
		projeto.setIdIntranet(dto.getIdIntranet());
		projeto.setTitulo(dto.getTitulo());
		projeto.setIniciativa(dto.getIniciativa());
		projeto.setCodigoProjeto(dto.getCodigoProjeto());
		projeto.setPlanoDeCusto(dto.getPlanoDeCusto());
		projeto.setGerEx(dto.getGerEx());
		projeto.setGerencia(dto.getGerencia());
		
		EquipeProjeto equipeProjeto = new EquipeProjeto();
		equipeProjeto.setIdEquipe(dto.getIdEquipeProjeto());
		projeto.setEquipeProjeto(equipeProjeto);
		
		Colaborador Colaborador = new Colaborador();
		Colaborador.setIdColaborador(dto.getIdResponsavelProjeto());
		
		projeto.setColaborador(Colaborador);
		
		projeto.setValorTotal(dto.getValorTotal());
		projeto.setDtOrcamentacao(dto.getDtOrcamentacao());
		projeto.setDtAprovacao(dto.getDtAprovacao());
		projeto.setDtInicioDev(dto.getDtInicioDEV());
		projeto.setDtFimDEV(dto.getDtFimDEV());
		projeto.setDtInicioHML(dto.getDtInicioHML());
		projeto.setDtFimHML(dto.getDtFimHML());
		projeto.setDtPrevisao(dto.getDtPrevisao());
		projeto.setDtImplantacao(dto.getDtImplantacao());
		projeto.setObservacao(dto.getObservacao());
		projeto.setDescricao(dto.getDescricao());
		
		SituacaoProjeto situacaoProjeto = new SituacaoProjeto();
		situacaoProjeto.setIdSituacaoProjeto(dto.getIdSituacaoProjeto());
		projeto.setSituacaoProjeto(situacaoProjeto);
		
		SituacaoFaturamentoProjeto situacaoFaturamentoProjeto = new SituacaoFaturamentoProjeto();
		situacaoFaturamentoProjeto.setIdSituacaoFaturamento(dto.getIdSituacaoFaturamento());
		projeto.setSituacaoFaturamento(situacaoFaturamentoProjeto);
		
		return projeto;
	}

}
