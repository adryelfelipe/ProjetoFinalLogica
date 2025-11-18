package Aplicacao.OrdemDeServico.Mapper;

import Aplicacao.Maquina.Dtos.Atualizar.AtualizarMaquinaResponse;
import Aplicacao.OrdemDeServico.Dtos.Atualizar.AtualizarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoMapper {
    // -- Atributos -- //
    private FuncionarioRepositorio funcionarioRepositorio;
    private MaquinaRepositorio maquinaRepositorio;

    public OrdemDeServicoMapper(FuncionarioRepositorio funcionarioRepositorio, MaquinaRepositorio maquinaRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.maquinaRepositorio = maquinaRepositorio;
    }

    public OrdemDeServico paraEntidade(CadastroOsRequest request, Departamento departamento) {
        return new OrdemDeServico(request.idTecnico(),
                request.idSupervisor(),
                request.idMaquina(),
                request.statusOS(),
                new Descricao(request.descricao()),
                new ValorOS(request.valorOS()),
                departamento, request.tipoOS());
    }

    // Cadastro foi um sucesso
    public CadastroOsResponse paraResponse(OrdemDeServico ordemDeServico) {
        return new CadastroOsResponse(ordemDeServico.getIdOs(),true, "✅ Cadastro da ordem de serviço foi um sucesso");
    }

    // Cadastro falhou
    public CadastroOsResponse paraResponse(String mensagem) {
        return new CadastroOsResponse(null, false, mensagem);
    }

    // Listagem de ordens de serviço em tal departamento foi um sucesso
    public ListarOsResponse paraListaOsResponseDepartamento(Departamento departamento, List<OrdemDeServico> lista) {
        List<OrdemServicoResponse> listaResponse = new ArrayList<>();

        for(OrdemDeServico os : lista) {
            if(os.getDepartamento() == departamento) {
                NomeFuncionario nomeTecnico = funcionarioRepositorio.buscarNome(os.getIdTecnico());
                NomeMaquina nomeMaquina = maquinaRepositorio.buscarNome(os.getIdMaquina());
                OrdemServicoResponse osResponse = new OrdemServicoResponse(os.getIdOs(), os.getStatusOS(),os.getDescricao() ,os.getTipoOS(), os.getValorOS(), os.getIdTecnico(), nomeTecnico, os.getIdMaquina(), nomeMaquina);
                listaResponse.add(osResponse);
            }
        }

        return new ListarOsResponse(listaResponse, true, "✅ Listagem de ordens de serviço realizada com sucesso!");
    }

    // Listagem de ordens de serviço de um determinado técnico foi um sucesso
    public ListarOsResponse paraListaOsResponseTecnico(long idTecnico, List<OrdemDeServico> lista) {
        List<OrdemServicoResponse> listaResponse = new ArrayList<>();

        for(OrdemDeServico os : lista) {
            if(os.getIdTecnico() == idTecnico) {
                NomeFuncionario nomeTecnico = funcionarioRepositorio.buscarNome(os.getIdTecnico());
                NomeMaquina nomeMaquina = maquinaRepositorio.buscarNome(os.getIdMaquina());
                OrdemServicoResponse osResponse = new OrdemServicoResponse(os.getIdOs(), os.getStatusOS(),os.getDescricao() ,os.getTipoOS(), os.getValorOS(), os.getIdTecnico(), nomeTecnico, os.getIdMaquina(), nomeMaquina);
                listaResponse.add(osResponse);
            }
        }

        return new ListarOsResponse(listaResponse, true, "✅ Listagem de ordens de serviço realizada com sucesso!");
    }

    // Listagem de ordens de serviço falhou
    public ListarOsResponse paraListaOsResponse(String mensagem) {
        return new ListarOsResponse(null, false, mensagem);
    }

    // Atualização foi um sucesso
    public AtualizarOsResponse paraAtualizarResponse(OrdemDeServico os) {
        return new AtualizarOsResponse(os.getIdMaquina(), true, "✅ Ordem de serviço atualizada com sucesso");
    }

    // Atualização falhou
    public AtualizarOsResponse paraAtualizarResponse(String mensagem) {
        return new AtualizarOsResponse(null, false, mensagem);
    }
}
