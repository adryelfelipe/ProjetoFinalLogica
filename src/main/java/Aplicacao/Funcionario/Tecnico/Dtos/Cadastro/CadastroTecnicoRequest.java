package Aplicacao.Funcionario.Tecnico.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;

import java.util.List;

public record CadastroTecnicoRequest(String nome, String cpf, String senha, List<Departamento> departamentos, Especialidade especialidade) {
}
