package Aplicacao.Funcionario.Supervisor.Exceptions.Requests;

import Dominio.Funcionario.Supervisor.Exceptions.SupervisorException;

public class AtualizarSupervisorNuloException extends SupervisorException {
    public AtualizarSupervisorNuloException() {
        super("As informações da atualização do supervisor devem ser bem definidas");
    }
}
