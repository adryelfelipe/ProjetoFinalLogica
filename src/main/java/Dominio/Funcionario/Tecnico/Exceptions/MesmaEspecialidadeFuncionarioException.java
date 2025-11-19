package Dominio.Funcionario.Tecnico.Exceptions;

import Dominio.Funcionario.Nucleo.Exceptions.MesmoDadoFuncionarioException;

public class MesmaEspecialidadeFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmaEspecialidadeFuncionarioException() {
        super("A especialidade deve ser diferente da atual");
    }
}
