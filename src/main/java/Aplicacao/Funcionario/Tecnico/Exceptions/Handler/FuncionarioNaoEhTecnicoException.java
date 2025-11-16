package Aplicacao.Funcionario.Tecnico.Exceptions.Handler;

public class FuncionarioNaoEhTecnicoException extends RuntimeException {
    public FuncionarioNaoEhTecnicoException() {
        super("O funcionário encontrado não é um técnico");
    }
}
