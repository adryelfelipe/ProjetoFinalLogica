package Aplicacao.OrdemDeServico.Dtos.Listar;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;

public record ListarOsRequest(long idFuncionario, Departamento departamento) {
}
