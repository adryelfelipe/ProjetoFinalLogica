package Aplicacao.OrdemDeServico.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Aplicacao.OrdemDeServico.Mapper.OrdemDeServicoMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.OrdemDeServico.Exceptions.OrdemDeServicoException;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;
import Dominio.OrdemDeServico.Servicos.OsServico;

public class OrdemDeServicoHandler {
    private OrdemDeServicoRepositorio ordemRepositorio;
    private OsServico osServico;
    private AutorizacaoServico autorizacaoServico;
    private OrdemDeServicoMapper ordemDeServicoMapper;

    public OrdemDeServicoHandler(OrdemDeServicoRepositorio ordemRepositorio, AutorizacaoServico autorizacaoServico, OsServico osServico, OrdemDeServicoMapper ordemDeServicoMapper) {
        this.ordemRepositorio = ordemRepositorio;
        this.autorizacaoServico = autorizacaoServico;
        this.osServico = osServico;
        this.ordemDeServicoMapper = ordemDeServicoMapper;
    }

    public CadastroOsResponse salvar(NivelAcesso nivelAcesso, CadastroOsRequest request) {
        try {
            autorizacaoServico.temAcessoSupervisor(nivelAcesso);
            osServico.supervisorExiste(request.idSupervisor());
            osServico.tecnicoExiste(request.idTecnico());
            osServico.tecnicoPertenceAoDepartamento(request.idTecnico(), request.departamento());
            osServico.supervisorPertenceAoDepartamento(request.idSupervisor(), request.departamento());
            OrdemDeServico os = ordemDeServicoMapper.paraEntidade(request);
            osServico.idUtilizado(os.getIdOs());
            ordemRepositorio.salvar(os);
            return ordemDeServicoMapper.paraResponse("Cadastro de OS realizado com sucesso");
        } catch (OrdemDeServicoException | AutorizacaoException e) {
            return ordemDeServicoMapper.paraResponse(e.getMessage());
        }
    }
}
