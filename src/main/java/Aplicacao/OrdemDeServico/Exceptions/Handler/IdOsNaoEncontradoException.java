package Aplicacao.OrdemDeServico.Exceptions.Handler;

public class IdOsNaoEncontradoException extends RuntimeException {
    public IdOsNaoEncontradoException() {
        super("O ID da OS informado não foi encontrado");
    }
}
