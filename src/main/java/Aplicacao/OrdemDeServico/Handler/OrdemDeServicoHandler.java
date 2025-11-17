package Aplicacao.OrdemDeServico.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.IdFuncionarioNaoEncontradoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Tecnico.Exceptions.Handler.FuncionarioNaoEhTecnicoException;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Mapper.OrdemDeServicoMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Dominio.OrdemDeServico.Exceptions.OrdemDeServicoException;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;
import Dominio.OrdemDeServico.Servicos.OsServico;

import java.util.List;

public class OrdemDeServicoHandler {
    private OrdemDeServicoRepositorio ordemRepositorio;
    private OsServico osServico;
    private AutorizacaoServico autorizacaoServico;
    private OrdemDeServicoMapper ordemDeServicoMapper;
    private MaquinaRepositorio maquinaRepositorio;
    private FuncionarioRepositorio funcionarioRepositorio;

    public OrdemDeServicoHandler(OrdemDeServicoRepositorio ordemRepositorio, AutorizacaoServico autorizacaoServico, OsServico osServico, OrdemDeServicoMapper ordemDeServicoMapper, MaquinaRepositorio maquinaRepositorio, FuncionarioRepositorio funcionarioRepositorio) {
        this.ordemRepositorio = ordemRepositorio;
        this.autorizacaoServico = autorizacaoServico;
        this.osServico = osServico;
        this.ordemDeServicoMapper = ordemDeServicoMapper;
        this.maquinaRepositorio = maquinaRepositorio;
        this.funcionarioRepositorio = funcionarioRepositorio;
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

    public ListarOsResponse listarOsDepartamento(NivelAcesso nivelAcesso, ListarOsRequest request) {
        try {
            // Se for Supervisor, lista somente as Ativas em seu departamento

            if(nivelAcesso == NivelAcesso.SUPERVISOR) {
                List<OrdemDeServico> listaOs = ordemRepositorio.listarOsAtivas();
                return ordemDeServicoMapper.paraListaOsResponseDepartamento(request.departamento(), listaOs);
            }


            // Se for Gerente, lista todas as ordens em seu departamento (Ativas e excluídas)
            if(nivelAcesso == NivelAcesso.GERENTE) {
                List<OrdemDeServico> listaOs = ordemRepositorio.listarOsTodas();
                return ordemDeServicoMapper.paraListaOsResponseDepartamento(request.departamento(), listaOs);
            }

            throw new AutorizacaoException();
        } catch (AutorizacaoException e) {
            return ordemDeServicoMapper.paraListaOsResponse(e.getMessage());
        }
    }

    public ListarOsResponse listarOsTecnico(NivelAcesso nivelAcesso, ListarOsRequest request) {
        try {
            if(nivelAcesso != NivelAcesso.TECNICO) {
                throw new AutorizacaoException();
            }

            List<OrdemDeServico> listaOs = ordemRepositorio.listarOsAtivas();
            Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());

            if(funcionario == null) {
                throw new IdFuncionarioNaoEncontradoException();
            }

            if(funcionario.getNivelAcesso() != NivelAcesso.TECNICO) {
                throw new FuncionarioNaoEhTecnicoException();
            }

            return ordemDeServicoMapper.paraListaOsResponseTecnico(request.idFuncionario(), listaOs);
        } catch (AutorizacaoException | IdFuncionarioNaoEncontradoException | FuncionarioNaoEhTecnicoException e) {
            return ordemDeServicoMapper.paraListaOsResponse(e.getMessage());
        }
    }
}
