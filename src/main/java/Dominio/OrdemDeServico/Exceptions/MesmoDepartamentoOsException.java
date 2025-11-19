package Dominio.OrdemDeServico.Exceptions;

public class MesmoDepartamentoOsException extends MesmoDadoOsException {
    public MesmoDepartamentoOsException() {
        super("O departamento deve ser diferente do atual");
    }
}
