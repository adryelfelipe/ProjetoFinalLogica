package Aplicacao.Funcionario.Supervisor.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;

import java.util.List;

public record CadastroSupervisorResponse(long id, NomeFuncionario nome, boolean status, String mensagem) {
}
