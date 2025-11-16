package Aplicacao.Funcionario.Supervisor.Dtos.Atualizar;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;

import java.util.List;

public record AtualizarSupervisorRequest(long id, String nome, String cpf, List<Departamento> departamentos, Double metaMensal) {
}
