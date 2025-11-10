package Dominio.Funcionario.Supervisor.Exceptions;

import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;

public class SupervisorException extends FuncionarioException {
    public SupervisorException(String message) {
        super(message);
    }
}
