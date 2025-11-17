package Aplicacao.Funcionario.Nucleo.Exceptions.Requests;

import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;

public class BuscarPorIdNuloException extends FuncionarioException {
  public BuscarPorIdNuloException() {
    super("As informações da busca por ID devem ser bem definidas");
  }
}
