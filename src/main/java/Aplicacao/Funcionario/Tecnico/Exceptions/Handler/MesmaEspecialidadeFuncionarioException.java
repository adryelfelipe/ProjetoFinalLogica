package Aplicacao.Funcionario.Tecnico.Exceptions.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.MesmoDadoFuncionarioException;

public class MesmaEspecialidadeFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmaEspecialidadeFuncionarioException() {
        super("A especialidade deve ser diferente da atual");
    }
}
