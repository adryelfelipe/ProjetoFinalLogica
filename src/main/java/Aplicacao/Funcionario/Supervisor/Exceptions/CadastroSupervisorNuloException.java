package Aplicacao.Funcionario.Supervisor.Exceptions;

public class CadastroSupervisorNuloException extends SupervisorRequestException {
    public CadastroSupervisorNuloException() {
        super("As informações do cadastro do supervisor devem ser bem definidas");
    }
}
