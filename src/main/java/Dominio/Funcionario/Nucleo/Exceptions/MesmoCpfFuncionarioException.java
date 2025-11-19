package Dominio.Funcionario.Nucleo.Exceptions;

public class MesmoCpfFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmoCpfFuncionarioException() {
        super("O cpf deve ser diferente do atual");
    }
}
