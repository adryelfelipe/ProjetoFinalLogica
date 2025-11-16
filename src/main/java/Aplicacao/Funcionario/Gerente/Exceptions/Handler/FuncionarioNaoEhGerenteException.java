package Aplicacao.Funcionario.Gerente.Exceptions.Handler;

public class FuncionarioNaoEhGerenteException extends RuntimeException {
    public FuncionarioNaoEhGerenteException() {
        super("O funcionário encontrado não é um gerente");
    }
}
