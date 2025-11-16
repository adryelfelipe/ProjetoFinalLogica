package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class MesmoNomeException extends MesmoDadoException {
    public MesmoNomeException() {
        super("O nome deve ser diferente do atual");
    }
}
