package Aplicacao.Ocorrencia.Controller;

import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdRequest;
import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcRequest;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcResponse;
import Aplicacao.Ocorrencia.Excepetions.Request.BuscarOcNulaException;
import Aplicacao.Ocorrencia.Excepetions.Request.ListarOcNulaException;
import Aplicacao.Ocorrencia.Handler.OcorrenciaHandler;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class OcorrenciaController {
    // -- Atributos -- //
    private OcorrenciaHandler ocorrenciaHandler;

    // -- Construtor -- //
    public OcorrenciaController(OcorrenciaHandler ocorrenciaHandler) {
        this.ocorrenciaHandler = ocorrenciaHandler;
    }

    // -- Métodos -- //
    public ListarOcResponse listarOcDepartamento(NivelAcesso nivelAcesso, ListarOcRequest request) {
        if(request == null) {
            throw new ListarOcNulaException();
        }

        return ocorrenciaHandler.listarOcDepartamento(nivelAcesso, request);
    }

    public BuscarOcPorIdResponse buscarOcPorId(NivelAcesso nivelAcesso, BuscarOcPorIdRequest request) {
        if(request == null) {
           throw new BuscarOcNulaException();
        }

        return ocorrenciaHandler.buscarPorId(nivelAcesso, request);
    }
}
