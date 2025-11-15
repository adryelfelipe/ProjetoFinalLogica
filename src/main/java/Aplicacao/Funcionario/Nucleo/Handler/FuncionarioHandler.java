package Aplicacao.Funcionario.Nucleo.Handler;

import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdUpdateResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Funcionario.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutoExclusaoException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Mapper.FuncionarioMapper;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;

public class FuncionarioHandler {
    // -- Atributos -- //
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioMapper funcionarioMapper;
    private AutorizacaoServico autorizacaoServico;

    // -- Construtor -- //
    public FuncionarioHandler(FuncionarioRepositorio funcionarioQueriesRepositorio, FuncionarioMapper funcionarioMapper, AutorizacaoServico autorizacaoServico) {
        this.funcionarioRepositorio = funcionarioQueriesRepositorio;
        this.funcionarioMapper = funcionarioMapper;
        this.autorizacaoServico = autorizacaoServico;
    }

    // -- Métodos -- //
    public LoginFuncionarioResponse login(LoginFuncionarioRequest request) {
        try {
            CPF cpf = new CPF(request.cpf());
            Senha senha = new Senha(request.senha());
            Funcionario funcionario = funcionarioRepositorio.buscar(cpf);

            if(funcionario == null) {
                return funcionarioMapper.paraLoginResponse("CPF ou senha inválidos");
            }

            if(!funcionario.igualMinhaSenha(senha)) {
                return funcionarioMapper.paraLoginResponse("CPF ou senha inválidos");
            }

            return funcionarioMapper.paraLoginResponse(funcionario);
        } catch (FuncionarioException e) {
            return funcionarioMapper.paraLoginResponse(e.getMessage());
        }
    }

    public ExcluirFuncionarioResponse excluir(NivelAcesso nivelAcesso, ExcluirFuncionarioRequest request) {
        try {
            autorizacaoServico.validaAcessoExcluir(nivelAcesso);

            if(request.idExcluidor() == request.idExcluido()) {
            throw new AutoExclusaoException();
            }

            Funcionario funcionarioExcluido = funcionarioRepositorio.buscar(request.idExcluido());

            if(funcionarioExcluido == null) {
                return funcionarioMapper.paraExcluirResponse("Funcionário não identificado com o id: " + request.idExcluido(), false);
            }

            autorizacaoServico.validaExclusaoAdm(funcionarioExcluido.souAdministrador());

            if(funcionarioExcluido.souGerente()) {
                autorizacaoServico.validaAcessoAdmin(nivelAcesso);
            }

            boolean sucesso = funcionarioRepositorio.excluir(request.idExcluido());
            return funcionarioMapper.paraExcluirResponse(sucesso ? "Funcionário excluído com sucesso" : "Falha ao excluir o funcionário", sucesso);
        } catch (AutorizacaoException | AutoExclusaoException e) {
            return funcionarioMapper.paraExcluirResponse(e.getMessage(), false);
        }
    }

    public ListaFuncionariosResponse listarFuncionariosParaAdm(NivelAcesso nivelAcesso) {
        try {
            autorizacaoServico.validaAcessoListarFuncionarios(nivelAcesso);
            return funcionarioMapper.paraListaResponseAdm(funcionarioRepositorio.listarFuncionarios());
        } catch (AutorizacaoException e) {
            return funcionarioMapper.paraListaResponseAdm(e.getMessage());
        }
    }

    public ListaFuncionariosResponse listarFuncionariosParaGerente(NivelAcesso nivelAcesso) {
        try {
            autorizacaoServico.validaAcessoListarFuncionarios(nivelAcesso);
            return funcionarioMapper.paraListaResponseGerente(funcionarioRepositorio.listarFuncionarios());
        } catch (AutorizacaoException e) {
            return funcionarioMapper.paraListaResponseGerente(e.getMessage());
        }
    }

    public FuncionarioPorIdResponse buscarPorId(FuncionarioPorIdRequest request) {
        Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());
        FuncionarioResponse funcionarioResponse = funcionarioMapper.paraFuncionarioResponse(funcionario);
        return new FuncionarioPorIdResponse(funcionarioResponse);
    }

    public Funcionario buscarPorIdUpdate(FuncionarioPorIdRequest request) {
        Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());
        return new FuncionarioPorIdUpdateResponse(funcionario);
    }
}
