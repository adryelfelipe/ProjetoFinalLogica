package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class MesmoCpfFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmoCpfFuncionarioException() {
        super("O cpf deve ser diferente do atual");
    }
}
