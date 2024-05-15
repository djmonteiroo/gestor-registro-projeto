package gestor.registro.projeto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestor.registro.lib.records.SituacaoFaturamentoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import gestor.registro.projeto.service.SituacaoFaturamentoService;

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
}
