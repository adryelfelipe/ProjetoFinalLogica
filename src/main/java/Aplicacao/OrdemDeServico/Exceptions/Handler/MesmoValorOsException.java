package Aplicacao.OrdemDeServico.Exceptions.Handler;

public class MesmoValorOsException extends MesmoDadoOsException {
    public MesmoValorOsException() {
        super("O valor deve ser diferente do atual");
    }
}
