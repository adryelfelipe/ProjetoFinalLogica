package Aplicacao.OrdemDeServico.Exceptions.Handler;

public class MesmoStatusOsException extends MesmoDadoOsException {
    public MesmoStatusOsException() {
        super("O Status deve ser diferente do atual");
    }
}
