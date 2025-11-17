package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class MesmoDepartamentoFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmoDepartamentoFuncionarioException() {
        super("O departamento deve ser diferente do atual");
    }
}
