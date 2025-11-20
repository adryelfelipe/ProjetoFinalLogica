package Aplicacao.Ocorrencia.Dtos.Buscar;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;

public record BuscarOcPorIdResponse(Long idOcorrencia, Long idMaquina, Departamento departamento, StatusOc statusOc, boolean status, String mensagem) {
}
