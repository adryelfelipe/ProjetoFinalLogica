package Aplicacao.Ocorrencia.Dtos.Listar;

import java.util.List;

public record ListarOcResponse(List<OcorrenciaResponse> listaResponse,  boolean status, String mensagem) {
}
