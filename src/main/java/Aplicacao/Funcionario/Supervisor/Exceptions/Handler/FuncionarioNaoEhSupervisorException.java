package Aplicacao.Funcionario.Supervisor.Exceptions.Handler;

public class FuncionarioNaoEhSupervisorException extends RuntimeException {
    public FuncionarioNaoEhSupervisorException() {
        super("O funcionário encontrado não é um supervisor");
    }
}
