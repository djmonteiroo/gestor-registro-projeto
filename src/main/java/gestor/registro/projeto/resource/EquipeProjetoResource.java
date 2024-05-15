package gestor.registro.projeto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestor.registro.lib.records.EquipeProjetoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import gestor.registro.projeto.service.EquipeProjetoService;

@RestController
@RequestMapping("/gestao-projeto/equipe")
public class EquipeProjetoResource implements GestaoProjetoResource {
	
	@Autowired
	private EquipeProjetoService equipeResource;
	
	@PostMapping
	public ResponseEntity<GestaoProjetoResponse<String>> criarEquipe(
			@RequestBody EquipeProjetoRecord equipeRecord) {

		try {
			return retornarSucesso(equipeResource.registrarEquipe(equipeRecord));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
