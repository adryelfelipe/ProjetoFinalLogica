package Aplicacao.Funcionario.Nucleo.Exceptions.Handler;

public class MesmoNomeFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmoNomeFuncionarioException() {
        super("O nome deve ser diferente do atual");
    }
}
