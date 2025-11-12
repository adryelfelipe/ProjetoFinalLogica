package Aplicacao.Funcionario.Gerente.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;

import java.util.List;

public record CadastroGerenteRequest(String nomeFuncionario, String cpf, String senha, List<Departamento> listaDepartamentos) {
}
