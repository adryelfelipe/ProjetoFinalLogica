package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class MesmoDepartamentoException extends MesmoDadoException {
    public MesmoDepartamentoException() {
        super("O departamento deve ser diferente do atual");
    }
}
