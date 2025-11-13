package Aplicacao.Funcionario.Nucleo.Exceptions.Requests;

public class ExclusaoFuncionarioNulaException extends RuntimeException {
    public ExclusaoFuncionarioNulaException() {
        super("As informações de exclusão devem ser bem definidas");
    }
}
