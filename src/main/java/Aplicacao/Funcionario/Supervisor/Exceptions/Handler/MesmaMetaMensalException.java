package Aplicacao.Funcionario.Supervisor.Exceptions.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.MesmoDadoException;

public class MesmaMetaMensalException extends MesmoDadoException {
    public MesmaMetaMensalException() {
        super("A meta mensal deve ser diferente da atual");
    }
}
