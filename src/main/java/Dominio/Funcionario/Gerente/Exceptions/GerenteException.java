package Dominio.Funcionario.Gerente.Exceptions;

import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;

public class GerenteException extends FuncionarioException {
    public GerenteException(String message) {
        super(message);
    }
}
