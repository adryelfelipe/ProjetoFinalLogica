package Dominio.Funcionario.Supervisor.Exceptions;

import Dominio.Funcionario.Nucleo.Exceptions.MesmoDadoFuncionarioException;

public class MesmaMetaMensalFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmaMetaMensalFuncionarioException() {
        super("A meta mensal deve ser diferente da atual");
    }
}
