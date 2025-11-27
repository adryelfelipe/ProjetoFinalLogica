package Aplicacao.Maquina.Handler;

import Aplicacao.Funcionario.Gerente.Exceptions.Handler.FuncionarioNaoEhGerenteException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.*;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Maquina.Dtos.Atualizar.AtualizarMaquinaRequest;
import Aplicacao.Maquina.Dtos.Atualizar.AtualizarMaquinaResponse;
import Aplicacao.Maquina.Dtos.BuscarPorId.MaquinaPorIdRequest;
import Aplicacao.Maquina.Dtos.BuscarPorId.MaquinaPorIdResponse;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Aplicacao.Maquina.Dtos.Exclusao.ExcluirMaquinaRequest;
import Aplicacao.Maquina.Dtos.Exclusao.ExcluirMaquinaResponse;
import Aplicacao.Maquina.Dtos.Listar.ListaMaquinasResponse;
import Aplicacao.Maquina.Exceptions.Handler.*;
import Aplicacao.Maquina.Mapper.MaquinaMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Maquina.Exceptions.MaquinaException;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Dominio.Maquina.Repositorios.MaquinaRepositorio;
import Dominio.Maquina.Servicos.MaquinaServico;

import java.util.List;

public class MaquinaHandler {

    // -- Atributos -- //
    private MaquinaServico maquinaServico;
    private MaquinaMapper maquinaMapper;
    private AutorizacaoServico autorizacaoServico;
    private MaquinaRepositorio maquinaRepositorio;

    // -- Construtor -- //
    public MaquinaHandler(MaquinaServico maquinaServico, MaquinaMapper maquinaMapper, AutorizacaoServico autorizacaoServico, MaquinaRepositorio maquinaRepositorio) {
        this.maquinaServico = maquinaServico;
        this.maquinaMapper = maquinaMapper;
        this.autorizacaoServico = autorizacaoServico;
        this.maquinaRepositorio = maquinaRepositorio;
    }

    // -- Métodos -- //
    public CadastroMaquinaResponse salvar(NivelAcesso nivelAcesso, CadastroMaquinaRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Maquina maquina = maquinaMapper.paraEntidade(request);
            maquinaRepositorio.salvar(maquina);
            return maquinaMapper.paraResponseCadastro(maquina);
        } catch (AutorizacaoException | MaquinaException e) {
            return maquinaMapper.paraResponseCadastro(e.getMessage());
        }
    }

    public ListaMaquinasResponse listarMaquinas(NivelAcesso nivelAcesso) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            List<Maquina> listaMaquinas = maquinaRepositorio.listaMaquinas();
            return maquinaMapper.paraListaResponse(listaMaquinas);
        } catch (AutorizacaoException e) {
            return maquinaMapper.paraListaResponse(e.getMessage());
        }
    }

    public MaquinaPorIdResponse buscar(NivelAcesso nivelAcesso, MaquinaPorIdRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Maquina maquina = maquinaRepositorio.buscar(request.idMaquina());

            if(maquina == null) {
                throw new IdMaquinaNaoEncontradoException();
            }

            return maquinaMapper.paraMaquinaPorIdResponse(maquina);
        } catch (AutorizacaoException | IdMaquinaNaoEncontradoException e) {
            return maquinaMapper.paraMaquinaPorIdResponse(e.getMessage());
        }
    }

    public AtualizarMaquinaResponse atualizar(NivelAcesso nivelAcesso, AtualizarMaquinaRequest request) {
        try {
            autorizacaoServico.validaAcessoAdmin(nivelAcesso);
            Maquina maquina = maquinaRepositorio.buscar(request.idMaquina());

            if(maquina == null) {
                throw new IdMaquinaNaoEncontradoException();
            }

            if(request.departamento() != null) {
                maquina.alteraDepartamento(request.departamento());
            }

            if(request.nome() != null) {
                NomeMaquina nome = new NomeMaquina(request.nome());
                maquina.alteraNome(nome);
            }

            if(request.status() != null) {
                maquina.alteraStatus(request.status());
            }

            maquinaRepositorio.atualizar(maquina);
            return maquinaMapper.paraAtualizarResponse(maquina);
        } catch (AutorizacaoException | MaquinaException |
                 IdMaquinaNaoEncontradoException | MesmoDadoMaquinaException e) {
            return maquinaMapper.paraAtualizarResponse(e.getMessage());
        }
    }

    public ExcluirMaquinaResponse excluir(NivelAcesso nivelAcesso, ExcluirMaquinaRequest request) {
        autorizacaoServico.validaAcessoGerente(nivelAcesso);
        boolean sucesso = maquinaRepositorio.excluir(request.idMaquina());
        return maquinaMapper.paraExcluirResponse(sucesso ? "Máquina excluída com sucesso" : "Falha ao excluir a máquina", sucesso);
    }
}
