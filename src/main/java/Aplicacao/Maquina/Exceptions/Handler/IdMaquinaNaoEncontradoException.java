package Aplicacao.Maquina.Exceptions.Handler;

public class IdMaquinaNaoEncontradoException extends RuntimeException {
    public IdMaquinaNaoEncontradoException() {
        super("Não foi possível encontrar uma máquina com o ID informado");
    }
}
