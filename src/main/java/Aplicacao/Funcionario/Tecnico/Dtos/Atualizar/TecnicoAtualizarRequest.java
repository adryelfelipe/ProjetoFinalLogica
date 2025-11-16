package Aplicacao.Funcionario.Tecnico.Dtos.Atualizar;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;

import java.util.List;

public record TecnicoAtualizarRequest(long id, String nome, String cpf, List<Departamento> departamentos, Especialidade especialidade) {
}
