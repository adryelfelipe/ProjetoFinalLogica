package Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId;

import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;

public record GerentePorIdResponse(long id, NomeFuncionario nome, CPF cpf, ListaDepartamentos listaDepartamentos, boolean status, String mensagem) {
}
