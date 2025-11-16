package Aplicacao.Funcionario.Gerente.Dtos.Atualizar;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;

import java.util.List;

public record AtualizarGerenteRequest(long id, String nome, String cpf, List<Departamento> departamentos) {
}
