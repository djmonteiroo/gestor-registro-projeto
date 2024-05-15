package gestor.registro.projeto.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestor.registro.lib.records.ResponsavelProjetoRecord;
import gestor.registro.lib.utils.dto.GestaoProjetoResource;
import gestor.registro.lib.utils.dto.GestaoProjetoResponse;
import gestor.registro.projeto.service.ResponsavelProjetoService;

@RestController
@RequestMapping("/gestao-projeto/responsavel")
public class ResponsavelProjetoResource implements GestaoProjetoResource {
	
	@Autowired
	private ResponsavelProjetoService responsavelService;

    @PostMapping(value = "/registrar")
    public ResponseEntity<GestaoProjetoResponse<String>> criarResponsavelProjeto(@RequestBody ResponsavelProjetoRecord responsavelRecord) {
    	
    	try {
			return retornarSucesso(responsavelService.registrarResponsavel(responsavelRecord));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

}