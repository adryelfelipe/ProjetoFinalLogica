package Aplicacao.Ocorrencia.Dtos.Listar;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;

public record OcorrenciaResponse(long idOcorrencia, long idMaquina, Departamento departamento, StatusOc statusOc, NomeMaquina nomeMaquina) {
}
