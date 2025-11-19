package Dominio.Funcionario.Nucleo.Exceptions;

public class MesmaSenhaFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmaSenhaFuncionarioException() {
        super("A senha deve ser diferente do atual");
    }
}
