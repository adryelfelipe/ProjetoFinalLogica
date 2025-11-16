package Aplicacao.OrdemDeServico.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Aplicacao.OrdemDeServico.Mapper.OrdemDeServicoMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Dominio.OrdemDeServico.Exceptions.OrdemDeServicoException;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;
import Dominio.OrdemDeServico.Servicos.OsServico;

public class OrdemDeServicoHandler {
    private OrdemDeServicoRepositorio ordemRepositorio;
    private OsServico osServico;
    private AutorizacaoServico autorizacaoServico;
    private OrdemDeServicoMapper ordemDeServicoMapper;
    private MaquinaRepositorio maquinaRepositorio;

    public OrdemDeServicoHandler(OrdemDeServicoRepositorio ordemRepositorio, AutorizacaoServico autorizacaoServico, OsServico osServico, OrdemDeServicoMapper ordemDeServicoMapper, MaquinaRepositorio maquinaRepositorio) {
        this.ordemRepositorio = ordemRepositorio;
        this.autorizacaoServico = autorizacaoServico;
        this.osServico = osServico;
        this.ordemDeServicoMapper = ordemDeServicoMapper;
        this.maquinaRepositorio = maquinaRepositorio;
    }

    public CadastroOsResponse salvar(NivelAcesso nivelAcesso, CadastroOsRequest request) {
        try {
            autorizacaoServico.validaAcessoSupervisor(nivelAcesso);
            osServico.maquinaExiste(request.idMaquina());
            Departamento departamento = maquinaRepositorio.maquinaParaDepartamento(request.idMaquina());
            OrdemDeServico os = ordemDeServicoMapper.paraEntidade(request, departamento);
            osServico.supervisorExiste(request.idSupervisor());
            osServico.tecnicoExiste(request.idTecnico());;
            osServico.tecnicoPertenceAoDepartamento(request.idTecnico(), os.getDepartamento());
            osServico.supervisorPertenceAoDepartamento(request.idSupervisor(), os.getDepartamento());
            ordemRepositorio.salvar(os);
            return ordemDeServicoMapper.paraResponse(os);
        } catch (OrdemDeServicoException | AutorizacaoException e) {
            return ordemDeServicoMapper.paraResponse(e.getMessage());
        }
    }
}
