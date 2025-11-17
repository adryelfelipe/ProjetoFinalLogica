package Aplicacao.Funcionario.Gerente.Exceptions.Requests;

public class AtualizarGerenteNuloException extends GerenteRequestException {
    public AtualizarGerenteNuloException() {
        super("As informações da atualização do gerente devem ser bem definidas");
    }
}
