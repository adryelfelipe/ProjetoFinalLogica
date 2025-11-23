package Infraestrutura.Persistencia.Implementacao.Ocorrencias.JDBC.Mapper;// Ou seu pacote de mappers

import Dominio.Ocorrencia.Enumeracoes.StatusOc;

public class OcorrenciasMapper {

    // Converte código INT para Enum StatusOc
    public StatusOc mapStatus(int statusOcCodigo, long ocorrenciaId) {
        StatusOc statusOc;

        switch (statusOcCodigo)
        {
            case 1:
                statusOc = StatusOc.ABERTA;
                break;
            case 2:
                statusOc = StatusOc.EM_ANDAMENTO;
                break;
            case 3:
                statusOc = StatusOc.FECHADA;
                break;
            default:
                throw new IllegalArgumentException(
                        "Status inválido para ID " + ocorrenciaId + ": " + statusOcCodigo
                );
        }
        return statusOc;
    }
}