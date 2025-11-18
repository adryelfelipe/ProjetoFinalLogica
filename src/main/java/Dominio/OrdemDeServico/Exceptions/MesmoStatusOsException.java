package Dominio.OrdemDeServico.Exceptions;

public class MesmoStatusOsException extends MesmoDadoOsException {
    public MesmoStatusOsException() {
        super("O Status deve ser diferente do atual");
    }
}
