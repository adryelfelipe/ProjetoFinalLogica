package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class AutorizacaoException extends RuntimeException {
    public AutorizacaoException() {
        super("Acesso não liberado para esta operação");
    }
}
