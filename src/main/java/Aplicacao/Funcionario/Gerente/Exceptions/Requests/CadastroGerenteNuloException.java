package Aplicacao.Funcionario.Gerente.Exceptions.Requests;

public class CadastroGerenteNuloException extends GerenteRequestException {
    public CadastroGerenteNuloException() {
        super("As informações do cadastro do gerente devem ser bem definidas");
    }
}
