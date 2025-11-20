package Aplicacao.Ocorrencia.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdRequest;
import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcRequest;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.OcorrenciaResponse;
import Aplicacao.Ocorrencia.Excepetions.Handler.OcorrenciaNaoEncontradaException;
import Aplicacao.Ocorrencia.Mapper.OcorrenciaMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Dominio.Ocorrencia.Ocorrencia;
import Dominio.Ocorrencia.Repositories.OcorrenciaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class OcorrenciaHandler {
    // -- Atributos -- //
    public OcorrenciaRepositorio ocorrenciaRepositorio;
    public OcorrenciaMapper ocorrenciaMapper;
    public AutorizacaoServico autorizacaoServico;

    // -- Construtor -- //
    public OcorrenciaHandler(OcorrenciaRepositorio ocorrenciaRepositorio, OcorrenciaMapper ocorrenciaMapper, AutorizacaoServico autorizacaoServico) {
        this.ocorrenciaRepositorio = ocorrenciaRepositorio;
        this.ocorrenciaMapper = ocorrenciaMapper;
        this.autorizacaoServico = autorizacaoServico;
    }

    // -- Métodos -- //
    public ListarOcResponse listarOcDepartamento(NivelAcesso nivelAcesso, ListarOcRequest request) {
        try {
            if(nivelAcesso == NivelAcesso.GERENTE) {
                List<OcorrenciaResponse> listaOcResponse = new ArrayList<>();
                for(Ocorrencia oc : ocorrenciaRepositorio.listarOcGerais()) {
                    if(oc.getDepartamento() == request.departamento()) {
                        OcorrenciaResponse ocResponse = ocorrenciaMapper.paraOcorrenciaResponse(oc);
                        listaOcResponse.add(ocResponse);
                    }
                }
                return ocorrenciaMapper.paraListaResponse(listaOcResponse);
            }

            if(nivelAcesso == NivelAcesso.SUPERVISOR) {
                List<OcorrenciaResponse> listaOcResponse = new ArrayList<>();
                for(Ocorrencia oc : ocorrenciaRepositorio.listarOcAtivas()) {
                    if(oc.getDepartamento() == request.departamento() && oc.getStatusOc() == StatusOc.ABERTA) {
                        OcorrenciaResponse ocResponse = ocorrenciaMapper.paraOcorrenciaResponse(oc);
                        listaOcResponse.add(ocResponse);
                    }
                }
                return ocorrenciaMapper.paraListaResponse(listaOcResponse);
            }

            throw new AutorizacaoException();
        } catch (AutorizacaoException e) {
            return ocorrenciaMapper.paraListaResponse(e.getMessage());
        }
    }

    public BuscarOcPorIdResponse buscarPorId(NivelAcesso nivelAcesso, BuscarOcPorIdRequest request) {
        try {
            autorizacaoServico.validaAcessoSupervisor(nivelAcesso);
            Ocorrencia oc = ocorrenciaRepositorio.buscarPorId(request.id());
            if(oc == null) {
                throw new OcorrenciaNaoEncontradaException("Não foi possível encontrar a ocorrência com o ID: " + request.id());
            }

            return ocorrenciaMapper.paraBuscaOcResponse(oc);
        } catch (OcorrenciaNaoEncontradaException | AutorizacaoException e) {
            return ocorrenciaMapper.paraBuscaOcResponse(e.getMessage());
        }
    }
}
