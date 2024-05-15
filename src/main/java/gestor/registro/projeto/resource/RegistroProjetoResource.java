package gestor.registro.projeto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestor.registro.lib.records.RegistroProjetoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import gestor.registro.projeto.service.RegistroProjetoService;

@RestController
@RequestMapping("/gestao-projeto")
public class RegistroProjetoResource implements GestaoProjetoResource {

	@Autowired
	private RegistroProjetoService registroService;

    @PostMapping
    public ResponseEntity<GestaoProjetoResponse<String>> criarProjeto(@RequestBody RegistroProjetoRecord projetoRecord) {
    	
    	try {
			return retornarSucesso(registroService.registrarNovoProjeto(projetoRecord));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
}
