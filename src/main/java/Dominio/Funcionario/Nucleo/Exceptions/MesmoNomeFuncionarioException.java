package Dominio.Funcionario.Nucleo.Exceptions;

public class MesmoNomeFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmoNomeFuncionarioException() {
        super("O nome deve ser diferente do atual");
    }
}
