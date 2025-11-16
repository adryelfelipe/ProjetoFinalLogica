package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class IdNaoEncontradoException extends RuntimeException {
    public IdNaoEncontradoException() {
        super("Não foi possível encontrar o funcionário com o ID informado");
    }
}
