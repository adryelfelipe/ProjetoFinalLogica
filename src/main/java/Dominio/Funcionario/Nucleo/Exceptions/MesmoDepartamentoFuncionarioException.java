package Dominio.Funcionario.Nucleo.Exceptions;

public class MesmoDepartamentoFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmoDepartamentoFuncionarioException() {
        super("O departamento deve ser diferente do atual");
    }
}
