package Aplicacao.Ocorrencia.Excepetions.Request;

public class ListarOcNulaException extends OcorrenciaRequestException {
    public ListarOcNulaException() {
        super("As informações da listagem das ocorrências devem ser bem definidas");
    }
}
