package Aplicacao.Ocorrencia.Excepetions.Request;

import Dominio.Ocorrencia.Ocorrencia;

public class BuscarOcNulaException extends OcorrenciaRequestException {
    public BuscarOcNulaException() {
        super("As informações para a busca da ocorrência devem ser bem definidas");
    }
}
