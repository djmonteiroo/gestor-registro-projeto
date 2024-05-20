package gestor.registro.projeto.resource;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;
import gestor.registro.lib.entity.SituacaoFaturamentoProjeto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import gestor.registro.lib.records.SituacaoFaturamentoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import gestor.registro.projeto.service.SituacaoFaturamentoService;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/gestao-projeto/situacao-faturamento")
public class SituacaoFaturamentoResource implements GestaoProjetoResource {
	
	@Autowired
	private SituacaoFaturamentoService situacaoFaturamentoService;
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<GestaoProjetoResponse<String>> criarSituacaoFaturamento(
			@RequestBody SituacaoFaturamentoRecord situacaoRecord) {

		try {
			return retornarSucesso(situacaoFaturamentoService.registrarSituacaoFaturamento(situacaoRecord));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping
	public ResponseEntity<GestaoProjetoResponse<List<SituacaoFaturamentoDto>>> listarSituacaoFaturamento(){
		return retornarResponse(HttpStatus.OK, situacaoFaturamentoService.listarSituacaoFaturamento());
	}
}
