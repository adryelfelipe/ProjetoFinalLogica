package Aplicacao.OrdemDeServico.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.IdFuncionarioNaoEncontradoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Tecnico.Exceptions.Handler.FuncionarioNaoEhTecnicoException;
import Aplicacao.Ocorrencia.Mapper.OcorrenciaMapper;
import Aplicacao.OrdemDeServico.Dtos.Atualizar.AtualizarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Atualizar.AtualizarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Exceptions.Handler.*;
import Aplicacao.OrdemDeServico.Mapper.OrdemDeServicoMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Dominio.Ocorrencia.Ocorrencia;
import Dominio.Ocorrencia.Repositories.OcorrenciaRepositorio;
import Dominio.Ocorrencia.Servicos.OcorrenciaServico;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;
import Dominio.OrdemDeServico.Exceptions.OrdemDeServicoException;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;
import Dominio.OrdemDeServico.Servicos.OsServico;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServicoHandler {
    private OrdemDeServicoRepositorio ordemRepositorio;
    private OsServico osServico;
    private AutorizacaoServico autorizacaoServico;
    private OrdemDeServicoMapper ordemDeServicoMapper;
    private MaquinaRepositorio maquinaRepositorio;
    private FuncionarioRepositorio funcionarioRepositorio;
    private OcorrenciaMapper ocorrenciaMapper;
    private OcorrenciaRepositorio ocorrenciaRepositorio;
    private OcorrenciaServico ocorrenciaServico;

    public OrdemDeServicoHandler(OrdemDeServicoRepositorio ordemRepositorio,
                                 AutorizacaoServico autorizacaoServico,
                                 OsServico osServico,
                                 OrdemDeServicoMapper ordemDeServicoMapper,
                                 MaquinaRepositorio maquinaRepositorio,
                                 FuncionarioRepositorio funcionarioRepositorio,
                                 OcorrenciaMapper ocorrenciaMapper,
                                 OcorrenciaRepositorio ocorrenciaRepositorio) {

        this.ordemRepositorio = ordemRepositorio;
        this.autorizacaoServico = autorizacaoServico;
        this.osServico = osServico;
        this.ordemDeServicoMapper = ordemDeServicoMapper;
        this.maquinaRepositorio = maquinaRepositorio;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.ocorrenciaMapper = ocorrenciaMapper;
        this.ocorrenciaRepositorio = ocorrenciaRepositorio;
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

            if(ordemRepositorio.numeroOrdensMaquina(request.idMaquina()) % 3 == 0 && !ocorrenciaRepositorio.existeOcorrenciaMaquina(request.idMaquina())) {
                Ocorrencia oc = ocorrenciaMapper.paraEntidade(request, departamento, StatusOc.ABERTA);
                ocorrenciaRepositorio.salvar(oc);
            }

            if(request.tipoOS() == TipoOS.PREDITIVA) {
                Ocorrencia oc = ocorrenciaRepositorio.buscarPorId(request.idOcorrencia());
                oc.alteraStatusOc(StatusOc.EM_ANDAMENTO);
                ocorrenciaRepositorio.atualizar(oc);
            }

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

    public ListarOsResponse listarOsTecnicoAtivas(NivelAcesso nivelAcesso, ListarOsRequest request) {
        try {
            autorizacaoServico.validaAcessoTecnico(nivelAcesso);
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

    public ListarOsResponse listarOsTecnicoAbertas(NivelAcesso nivelAcesso, ListarOsRequest request) {
        try {
            autorizacaoServico.validaAcessoTecnico(nivelAcesso);
            List<OrdemDeServico> listaOsAtivas = ordemRepositorio.listarOsAtivas();

            List<OrdemDeServico> listaOsAbertas = new ArrayList<>();
            for (OrdemDeServico os : listaOsAtivas) {
                if(os.getStatusOS() == StatusOS.ABERTA) {
                    listaOsAbertas.add(os);
                }
            }
            Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());

            if(funcionario == null) {
                throw new IdFuncionarioNaoEncontradoException();
            }

            if(funcionario.getNivelAcesso() != NivelAcesso.TECNICO) {
                throw new FuncionarioNaoEhTecnicoException();
            }

            return ordemDeServicoMapper.paraListaOsResponseTecnico(request.idFuncionario(), listaOsAbertas);
        } catch (AutorizacaoException | IdFuncionarioNaoEncontradoException | FuncionarioNaoEhTecnicoException e) {
            return ordemDeServicoMapper.paraListaOsResponse(e.getMessage());
        }
    }

    public ListarOsResponse listarOsTecnicoAndamento(NivelAcesso nivelAcesso, ListarOsRequest request) {
        try {
            autorizacaoServico.validaAcessoTecnico(nivelAcesso);
            List<OrdemDeServico> listaOsAtivas = ordemRepositorio.listarOsAtivas();

            List<OrdemDeServico> listaOsAndamento = new ArrayList<>();
            for (OrdemDeServico os : listaOsAtivas) {
                if(os.getStatusOS() == StatusOS.EM_ANDAMENTO) {
                    listaOsAndamento.add(os);
                }
            }
            Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());

            if(funcionario == null) {
                throw new IdFuncionarioNaoEncontradoException();
            }

            if(funcionario.getNivelAcesso() != NivelAcesso.TECNICO) {
                throw new FuncionarioNaoEhTecnicoException();
            }

            return ordemDeServicoMapper.paraListaOsResponseTecnico(request.idFuncionario(), listaOsAndamento);
        } catch (AutorizacaoException | IdFuncionarioNaoEncontradoException | FuncionarioNaoEhTecnicoException e) {
            return ordemDeServicoMapper.paraListaOsResponse(e.getMessage());
        }
    }

    public AtualizarOsResponse atualizarOsTecnico(NivelAcesso nivelAcesso, AtualizarOsRequest request) {
        try {
            autorizacaoServico.validaAcessoTecnico(nivelAcesso);
            OrdemDeServico os = ordemRepositorio.buscarPorId(request.idOs());

            if(os == null) {
                throw new IdOsNaoEncontradoException();
            }

            if(request.descricao() != null) {
                throw new AutorizacaoException();
            }

            if(request.valorOs() != null) {
                throw new AutorizacaoException();
            }

            if(request.statusOS() != null) {
                os.alteraStatusOs(request.statusOS(), nivelAcesso);

                if(request.statusOS() == StatusOS.FECHADA) {
                    ordemRepositorio.excluirPorId(request.idOs());

                    if(os.getTipoOS() == TipoOS.PREDITIVA) {
                        Ocorrencia ocorrencia = ocorrenciaRepositorio.ocorrenciaPorIdMaquina(os.getIdMaquina());
                        ocorrencia.alteraStatusOc(StatusOc.FECHADA);
                        ocorrenciaRepositorio.atualizar(ocorrencia);
                        ocorrenciaRepositorio.excluirPorId(ocorrencia.getIdOcorrencia());
                    }
                }
            }

            ordemRepositorio.atualizar(os);
            return ordemDeServicoMapper.paraAtualizarResponse(os);
        } catch (AutorizacaoException | IdOsNaoEncontradoException | OrdemDeServicoException e) {
            return ordemDeServicoMapper.paraAtualizarResponse(e.getMessage());
        }
    }

    public AtualizarOsResponse atualizarOsSupervisor(NivelAcesso nivelAcesso, AtualizarOsRequest request) {
        try {
            autorizacaoServico.validaAcessoSupervisor(nivelAcesso);
            OrdemDeServico os = ordemRepositorio.buscarPorId(request.idOs());

            if(os == null) {
                throw new IdOsNaoEncontradoException();
            }

            if(request.descricao() != null) {
                Descricao descricao = new Descricao(request.descricao());
                os.alteraDescricao(descricao);
            }

            if(request.valorOs() != null) {
                ValorOS valorOS = new ValorOS(request.valorOs());
                os.alteraValorOS(valorOS);
            }

            if(request.statusOS() != null) {
                os.alteraStatusOs(request.statusOS(), nivelAcesso);
            }

            ordemRepositorio.atualizar(os);
            return ordemDeServicoMapper.paraAtualizarResponse(os);
        } catch (AutorizacaoException | IdOsNaoEncontradoException | OrdemDeServicoException e) {
            return ordemDeServicoMapper.paraAtualizarResponse(e.getMessage());
        }
    }
}
