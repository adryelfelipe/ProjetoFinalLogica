package Aplicacao.OrdemDeServico.Exceptions.Requests;

public class CadastroOsNulaException extends OsRequestException {
    public CadastroOsNulaException() {
        super("As informações da ordem de serviço devem ser bem definidas");
    }
}
