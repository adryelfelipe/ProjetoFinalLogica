package Dominio.OrdemDeServico.Exceptions;

public class MesmoValorOsException extends MesmoDadoOsException {
    public MesmoValorOsException() {
        super("O valor deve ser diferente do atual");
    }
}
