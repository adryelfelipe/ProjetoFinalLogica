package Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios;

import java.util.List;

public record ListaFuncionariosResponse(List<FuncionarioResponse> listaFuncionarios, boolean status, String mensagem) {
}
