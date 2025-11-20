package Aplicacao.Ocorrencia.Mapper;

import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.OcorrenciaResponse;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Dominio.Ocorrencia.Ocorrencia;

import java.util.List;

public class OcorrenciaMapper {
    // -- Atributos -- //
    private MaquinaRepositorio maquinaRepositorio;

    // -- Construtor -- //
    public OcorrenciaMapper(MaquinaRepositorio maquinaRepositorio) {
        this.maquinaRepositorio = maquinaRepositorio;
    }

    // -- Métodos -- //
    public Ocorrencia paraEntidade(CadastroOsRequest request, Departamento departamento, StatusOc statusOc) {
        return new Ocorrencia(request.idMaquina(), departamento, statusOc);
    }

    public OcorrenciaResponse paraOcorrenciaResponse(Ocorrencia ocorrencia) {
        NomeMaquina nomeMaquina = maquinaRepositorio.buscarNome(ocorrencia.getIdMaquina());
        return new OcorrenciaResponse(ocorrencia.getIdOcorrencia(), ocorrencia.getIdMaquina(), ocorrencia.getDepartamento(), ocorrencia.getStatusOc(), nomeMaquina);
    }

    // Listagem foi um sucesso
    public ListarOcResponse paraListaResponse(List<OcorrenciaResponse> listaOcResponse) {
        return new ListarOcResponse(listaOcResponse, true, "✅ Listagem realizada com sucesso");
    }

    // Listagem falhou
    public ListarOcResponse paraListaResponse(String mensagem) {
        return new ListarOcResponse(null, false, mensagem);
    }

    // Busca por ID foi um sucesso
    public BuscarOcPorIdResponse paraBuscaOcResponse(Ocorrencia ocorrencia) {
        return new BuscarOcPorIdResponse(ocorrencia.getIdOcorrencia(), ocorrencia.getIdMaquina(), ocorrencia.getDepartamento(), ocorrencia.getStatusOc(), true, "✅ Busca por ID realizada com sucesso!");
    }

    // Busca por ID falhou
    public BuscarOcPorIdResponse paraBuscaOcResponse(String mensagem) {
        return new BuscarOcPorIdResponse(null, null, null, null, false, mensagem);
    }

}
