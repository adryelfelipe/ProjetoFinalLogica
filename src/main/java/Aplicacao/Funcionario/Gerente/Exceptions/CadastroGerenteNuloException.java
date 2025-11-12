package Aplicacao.Funcionario.Gerente.Exceptions;

public class CadastroGerenteNuloException extends GerenteRequestException {
    public CadastroGerenteNuloException() {
        super("As informações do cadastro do gerente devem ser bem definidas");
    }
}
