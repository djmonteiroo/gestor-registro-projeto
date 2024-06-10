package gestor.registro.projeto.utils;

import gestor.registro.lib.dto.SituacaoFaturamentoDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorUtils {

    public static String tratamentoSaidaData(final LocalDateTime dtTratamento) {
        String outputPattern = "dd/MM/yyyy HH:mm";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(outputPattern);
        return dtTratamento.format(inputFormatter);
    }
}
