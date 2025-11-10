package Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;

public record CadastroGerenteRequest(NomeFuncionario nomeFuncionario, CPF cpf, Senha senha, ListaDepartamentos listaDepartamentos) {
}
