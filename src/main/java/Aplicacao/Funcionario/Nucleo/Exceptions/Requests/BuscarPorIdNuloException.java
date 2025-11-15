package Aplicacao.Funcionario.Nucleo.Exceptions.Requests;

public class BuscarPorIdNuloException extends RuntimeException {
    public BuscarPorIdNuloException() {
        super("As informações de busca de funcionário por ID devem ser bem definidas");
    }
}
