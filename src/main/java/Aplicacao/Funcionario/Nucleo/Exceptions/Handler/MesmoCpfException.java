package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class MesmoCpfException extends MesmoDadoException {
    public MesmoCpfException() {
        super("O cpf deve ser diferente do atual");
    }
}
