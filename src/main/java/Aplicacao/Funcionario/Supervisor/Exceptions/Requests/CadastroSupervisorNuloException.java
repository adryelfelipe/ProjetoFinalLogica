package Aplicacao.Funcionario.Supervisor.Exceptions.Requests;

public class CadastroSupervisorNuloException extends SupervisorRequestException {
    public CadastroSupervisorNuloException() {
        super("As informações do cadastro do supervisor devem ser bem definidas");
    }
}
