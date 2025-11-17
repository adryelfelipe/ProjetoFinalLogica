package Aplicacao.Funcionario.Supervisor.Exceptions.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.MesmoDadoFuncionarioException;

public class MesmaMetaMensalFuncionarioException extends MesmoDadoFuncionarioException {
    public MesmaMetaMensalFuncionarioException() {
        super("A meta mensal deve ser diferente da atual");
    }
}
