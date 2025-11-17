package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class IdFuncionarioNaoEncontradoException extends RuntimeException {
    public IdFuncionarioNaoEncontradoException() {
        super("Não foi possível encontrar um funcionário com o ID informado");
    }
}
