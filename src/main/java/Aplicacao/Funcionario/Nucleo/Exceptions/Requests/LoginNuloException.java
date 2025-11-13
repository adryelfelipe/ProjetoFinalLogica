package Aplicacao.Funcionario.Nucleo.Exceptions.Requests;

public class LoginNuloException extends RuntimeException {
    public LoginNuloException() {
        super("As informações do login devem ser bem definidas");
    }
}
