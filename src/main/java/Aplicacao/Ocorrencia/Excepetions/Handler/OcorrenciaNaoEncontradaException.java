package Aplicacao.Ocorrencia.Excepetions.Handler;

public class OcorrenciaNaoEncontradaException extends RuntimeException {
    public OcorrenciaNaoEncontradaException(String message) {
        super(message);
    }
}
