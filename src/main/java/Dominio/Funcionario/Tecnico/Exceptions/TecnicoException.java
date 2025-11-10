package Dominio.Funcionario.Tecnico.Exceptions;

import Dominio.Funcionario.Funcionario.Exceptions.FuncionarioException;

public class TecnicoException extends FuncionarioException {
    public TecnicoException(String message) {
        super(message);
    }
}
