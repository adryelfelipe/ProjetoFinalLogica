package Aplicacao.Maquina.Dtos.Listar;

import java.util.List;

public record ListaMaquinasResponse(List<MaquinaResponse> listaMaquinas, boolean status, String mensagem) {
}
