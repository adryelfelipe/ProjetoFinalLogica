package Dominio.OrdemDeServico.Exceptions;

public class MesmaDescricaoOsException extends MesmoDadoOsException {
    public MesmaDescricaoOsException() {
        super("A descrição deve ser diferente da atual");
    }
}
