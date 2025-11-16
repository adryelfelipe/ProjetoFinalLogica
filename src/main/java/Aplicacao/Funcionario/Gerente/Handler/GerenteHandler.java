package Aplicacao.Funcionario.Gerente.Handler;

import Aplicacao.Funcionario.Gerente.Dtos.Atualizar.AtualizarGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.Exceptions.Handler.FuncionarioNaoEhGerenteException;
import Aplicacao.Funcionario.Gerente.Mapper.GerenteMapper;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.*;
import Aplicacao.Funcionario.Nucleo.Mapper.FuncionarioMapper;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Nucleo.Servicos.TipoFuncionarioServico;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;

public class GerenteHandler {
    // -- Atributos -- //
    private GerenteMapper gerenteMapper;
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioServico funcionarioServico;
    private AutorizacaoServico autorizacaoServico;
    private TipoFuncionarioServico tipoFuncionarioServico;
    private FuncionarioMapper funcionarioMapper;

    // -- Construtor -- //
    public GerenteHandler(GerenteMapper gerenteMapper, FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico, AutorizacaoServico autorizacaoServico, TipoFuncionarioServico tipoFuncionarioServico, FuncionarioMapper funcionarioMapper) {
        this.gerenteMapper = gerenteMapper;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
        this.autorizacaoServico = autorizacaoServico;
        this.tipoFuncionarioServico = tipoFuncionarioServico;
        this.funcionarioMapper = funcionarioMapper;
    }

    // -- Métodos -- //
    public CadastroGerenteResponse cadastrar(NivelAcesso nivelAcesso, CadastroGerenteRequest request) {
        try {
            autorizacaoServico.validaAcessoAdmin(nivelAcesso);
            Gerente gerente = gerenteMapper.paraEntidade(request);
            funcionarioServico.cpfUtilizado(gerente.getCpf());
            funcionarioRepositorio.salvar(gerente);
            return gerenteMapper.paraResponseCadastro(gerente);
        } catch (AutorizacaoException | FuncionarioException e) {
            return gerenteMapper.paraResponseCadastro(e.getMessage());
        }
    }

    public GerentePorIdResponse buscarPorId(NivelAcesso nivelAcesso, FuncionarioPorIdRequest request) {
        try {
            autorizacaoServico.validaAcessoAdmin(nivelAcesso);
            Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());
            Gerente gerente = tipoFuncionarioServico.validaFuncionarioGerente(funcionario);

            return gerenteMapper.paraResponseGerente(gerente);
        } catch (AutorizacaoException | FuncionarioNaoEhGerenteException | IdNaoEncontradoException e) {
            return gerenteMapper.paraResponseGerente(e.getMessage());
        }
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, AtualizarGerenteRequest request) {
        try {
            autorizacaoServico.validaAcessoAdmin(nivelAcesso);
            Funcionario funcionario = funcionarioRepositorio.buscar(request.id());
            Gerente gerente = tipoFuncionarioServico.validaFuncionarioGerente(funcionario);

            if(request.cpf() != null) {
                CPF cpf = new CPF(request.cpf());

                if(gerente.igualMeuCpf(cpf)) {
                    throw new MesmoCpfException();
                }

                funcionarioServico.cpfUtilizado(cpf);

                gerente.alteraCpf(cpf);
            }

            if(request.nome() != null) {
                NomeFuncionario nome = new NomeFuncionario(request.nome());

                if(gerente.igualMeuNome(nome)) {
                    throw new MesmoNomeException();
                }

                gerente.alteraNome(nome);
            }

            if(request.departamentos() != null) {
                ListaDepartamentos departamentos = new ListaDepartamentos(request.departamentos());

                if(gerente.igualMeuDepartamento(departamentos.getListaDepartamentos().getFirst())) {
                    throw new MesmoDepartamentoException();
                }

                gerente.alteraListaDepartamentos(departamentos);
            }

            funcionarioRepositorio.atualizar(gerente);
            return funcionarioMapper.paraResponseAtualizar(gerente);
        } catch (AutorizacaoException | FuncionarioException | FuncionarioNaoEhGerenteException |
                 IdNaoEncontradoException | MesmoDadoException e) {
            return funcionarioMapper.paraResponseAtualizar(e.getMessage());
        }
    }
}
