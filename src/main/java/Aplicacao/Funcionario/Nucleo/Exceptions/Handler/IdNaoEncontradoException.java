package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class IdNaoEncontradoException extends RuntimeException {
    public IdNaoEncontradoException() {
        super("Não foi possível encontrar um funcionário com o ID informado");
    }
}
