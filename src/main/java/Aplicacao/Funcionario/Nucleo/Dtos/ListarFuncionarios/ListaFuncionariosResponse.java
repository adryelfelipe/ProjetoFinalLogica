package Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios;

import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;

import java.util.List;

public record ListaFuncionariosResponse(List<FuncionarioResponse> listaFuncionarios, boolean status, String mensagem) {
}
