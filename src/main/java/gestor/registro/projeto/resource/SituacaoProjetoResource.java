package gestor.registro.projeto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import gestor.registro.lib.records.SituacaoProjetoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import gestor.registro.projeto.service.SituacaoProjetoService;

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
	public String situacaoProjeto() {
		return "situacaoProjeto/situacaoProjeto";
	}
}
