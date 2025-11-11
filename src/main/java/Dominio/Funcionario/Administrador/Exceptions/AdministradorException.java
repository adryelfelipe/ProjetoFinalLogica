package Dominio.Funcionario.Administrador.Exceptions;

import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;

public class AdministradorException extends FuncionarioException {
    public AdministradorException(String message) {
        super(message);
    }
}
