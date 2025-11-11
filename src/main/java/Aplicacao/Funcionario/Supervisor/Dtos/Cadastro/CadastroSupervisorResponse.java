package Aplicacao.Funcionario.Supervisor.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;

import java.util.List;

public record CadastroSupervisorResponse(long id, String nome, boolean status, String mensagem) {
}
