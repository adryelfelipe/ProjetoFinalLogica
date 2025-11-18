package Aplicacao.OrdemDeServico.Exceptions.Requests;

public class AtualizarOsRequestNulaException extends OsRequestException {
    public AtualizarOsRequestNulaException() {
        super("As informações da ordem de serviço devem ser bem definidas");
    }
}
