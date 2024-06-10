package gestor.registro.projeto.resource;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;
import gestor.registro.lib.dto.SituacaoProjetoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import gestor.registro.lib.records.SituacaoProjetoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import gestor.registro.projeto.service.SituacaoProjetoService;

import java.util.List;

@Controller
//@RestController
@RequestMapping("/gestao-projeto/situacao-projeto")
public class SituacaoProjetoResource implements GestaoProjetoResource {
	
	@Autowired
	private SituacaoProjetoService situacaoService;
	
	@PostMapping(value = "/registrar")
	public ResponseEntity<GestaoProjetoResponse<String>> criarEquipe(
			@RequestBody SituacaoProjetoRecord situacaoRecord) {

		try {
			return retornarSucesso(situacaoService.registrarSituacao(situacaoRecord));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping
	public ResponseEntity<GestaoProjetoResponse<List<SituacaoProjetoDto>>> listarSituacaoProjeto(){
		return retornarResponse(HttpStatus.OK, situacaoService.listarSituacaProjeto());
	}

	@PutMapping("/desativar/{idSituacaoProjeto}")
	public ResponseEntity<GestaoProjetoResponse<String>> desativarSituacaoProjeto(@PathVariable("idSituacaoProjeto") Long idSituacaoProjeto){
		return retornarResponse(HttpStatus.OK, situacaoService.desativarSituacaoProjeto(idSituacaoProjeto));
	}

	@PutMapping("/ativar/{idSituacaoProjeto}")
	public ResponseEntity<GestaoProjetoResponse<String>> ativarSituacaoProjeto(@PathVariable("idSituacaoProjeto") Long idSituacaoProjeto){
		return retornarResponse(HttpStatus.OK, situacaoService.ativarSituacaoProjeto(idSituacaoProjeto));
	}
}
