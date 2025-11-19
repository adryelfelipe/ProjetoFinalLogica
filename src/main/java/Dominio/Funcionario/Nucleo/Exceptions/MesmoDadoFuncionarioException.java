package Dominio.Funcionario.Nucleo.Exceptions;

public class MesmoDadoFuncionarioException extends RuntimeException {
    public MesmoDadoFuncionarioException(String message) {
        super(message);
    }
}
