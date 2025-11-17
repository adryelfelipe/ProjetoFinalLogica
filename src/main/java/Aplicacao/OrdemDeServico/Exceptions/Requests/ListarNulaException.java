package Aplicacao.OrdemDeServico.Exceptions.Requests;

public class ListarNulaException extends OsRequestException {
    public ListarNulaException() {
        super("As informações do pedido de listagem devem estar bem definidas");
    }
}
