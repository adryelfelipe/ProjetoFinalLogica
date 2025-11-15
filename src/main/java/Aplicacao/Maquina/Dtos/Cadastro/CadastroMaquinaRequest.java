package Aplicacao.Maquina.Dtos.Cadastro;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Enumeracoes.StatusMaquina;

public record CadastroMaquinaRequest(String nome, Departamento departamento, StatusMaquina status) {
}
