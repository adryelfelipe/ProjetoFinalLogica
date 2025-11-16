package Aplicacao.Funcionario.Tecnico.Exceptions.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.MesmoDadoException;

public class MesmaEspecialidadeException extends MesmoDadoException {
    public MesmaEspecialidadeException() {
        super("A especialidade deve ser diferente da atual");
    }
}
