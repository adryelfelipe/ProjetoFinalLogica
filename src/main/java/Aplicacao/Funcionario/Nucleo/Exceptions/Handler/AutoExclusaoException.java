package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class AutoExclusaoException extends RuntimeException {
    public AutoExclusaoException() {
        super("Não é possível excluir a si mesmo");
    }
}
