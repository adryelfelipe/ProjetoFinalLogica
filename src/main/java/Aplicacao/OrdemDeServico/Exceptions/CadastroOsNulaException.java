package Aplicacao.OrdemDeServico.Exceptions;

public class CadastroOsNulaException extends OsRequestException {
    public CadastroOsNulaException() {
        super("As informações da ordem de serviço devem ser bem definidas");
    }
}
