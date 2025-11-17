package Aplicacao.Funcionario.Supervisor.Handler;

import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.*;
import Aplicacao.Funcionario.Nucleo.Mapper.FuncionarioMapper;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Nucleo.Servicos.TipoFuncionarioServico;
import Aplicacao.Funcionario.Supervisor.Dtos.Atualizar.AtualizarSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId.SupervisorPorIdResponse;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorResponse;
import Aplicacao.Funcionario.Supervisor.Exceptions.Handler.FuncionarioNaoEhSupervisorException;
import Aplicacao.Funcionario.Supervisor.Exceptions.Handler.MesmaMetaMensalFuncionarioException;
import Aplicacao.Funcionario.Supervisor.Mapper.SupervisorMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Funcionario.Supervisor.Supervisor;

public class SupervisorHandler {
    // -- Atributos -- //
    private SupervisorMapper supervisorMapper;
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioServico funcionarioServico;
    private AutorizacaoServico autorizacaoServico;
    private TipoFuncionarioServico tipoFuncionarioServico;
    private FuncionarioMapper funcionarioMapper;

    // -- Construtor -- //
    public SupervisorHandler(SupervisorMapper supervisorMapper, FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico, AutorizacaoServico autorizacaoServico, TipoFuncionarioServico tipoFuncionarioServico, FuncionarioMapper funcionarioMapper) {
        this.supervisorMapper = supervisorMapper;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
        this.autorizacaoServico = autorizacaoServico;
        this.tipoFuncionarioServico = tipoFuncionarioServico;
        this.funcionarioMapper = funcionarioMapper;
    }

    // -- Métodos -- //
    public CadastroSupervisorResponse salvar(NivelAcesso nivelAcesso, CadastroSupervisorRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Supervisor supervisor = supervisorMapper.paraEntidade(request);
            funcionarioServico.cpfUtilizado(supervisor.getCpf());
            funcionarioRepositorio.salvar(supervisor);
            return supervisorMapper.paraResponseCadastro(supervisor);
        } catch (AutorizacaoException | FuncionarioException e) {
            return supervisorMapper.paraResponseCadastro(e.getMessage());
        }
    }

    public SupervisorPorIdResponse buscarPorId(NivelAcesso nivelAcesso, FuncionarioPorIdRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());
            Supervisor supervisor = tipoFuncionarioServico.validaFuncionarioSupervisor(funcionario);

            return supervisorMapper.paraResponseSupervisor(supervisor);
        } catch (AutorizacaoException | FuncionarioNaoEhSupervisorException | IdFuncionarioNaoEncontradoException e) {
            return supervisorMapper.paraResponseSupervisor(e.getMessage());
        }
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, AtualizarSupervisorRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Funcionario funcionario = funcionarioRepositorio.buscar(request.id());
            Supervisor supervisor = tipoFuncionarioServico.validaFuncionarioSupervisor(funcionario);

            if(request.cpf() != null) {
                CPF cpf = new CPF(request.cpf());

                if(supervisor.igualMeuCpf(cpf)) {
                    throw new MesmoCpfFuncionarioException();
                }

                funcionarioServico.cpfUtilizado(cpf);
                supervisor.alteraCpf(cpf);
            }

            if(request.nome() != null) {
                NomeFuncionario nome = new NomeFuncionario(request.nome());

                if(supervisor.igualMeuNome(nome)) {
                    throw new MesmoNomeFuncionarioException();
                }

                supervisor.alteraNome(nome);
            }

            if(request.departamentos() != null) {
                ListaDepartamentos departamentos = new ListaDepartamentos(request.departamentos());

                if(supervisor.igualMeuDepartamento(departamentos.getListaDepartamentos().getFirst())) {
                    throw new MesmoDepartamentoFuncionarioException();
                }

                supervisor.alteraListaDepartamentos(departamentos);
            }

            if(request.metaMensal() != null) {
                MetaMensal metaMensal = new MetaMensal(request.metaMensal());

                if(supervisor.igualMinhaMetaMensal(metaMensal)) {
                    throw new MesmaMetaMensalFuncionarioException();
                }

                supervisor.alteraMetaMensal(metaMensal);
            }

            funcionarioRepositorio.atualizar(supervisor);
            return funcionarioMapper.paraResponseAtualizar(supervisor);
        } catch (AutorizacaoException | FuncionarioException | FuncionarioNaoEhSupervisorException |
                 IdFuncionarioNaoEncontradoException | MesmoDadoFuncionarioException e) {
            return funcionarioMapper.paraResponseAtualizar(e.getMessage());
        }
    }
}
