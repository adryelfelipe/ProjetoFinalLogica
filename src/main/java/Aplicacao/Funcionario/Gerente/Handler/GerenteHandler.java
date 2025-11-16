package Aplicacao.Funcionario.Gerente.Handler;

import Aplicacao.Funcionario.Gerente.Dtos.Atualizar.GerenteAtualizarRequest;
import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.Exceptions.Handler.FuncionarioNaoEhGerenteException;
import Aplicacao.Funcionario.Gerente.Mapper.GerenteMapper;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.IdNaoEncontradoException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.MesmoDadoException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Requests.BuscarPorIdNuloException;
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

    // -- Construtor -- //
    public GerenteHandler(GerenteMapper gerenteMapper, FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico, AutorizacaoServico autorizacaoServico, TipoFuncionarioServico tipoFuncionarioServico) {
        this.gerenteMapper = gerenteMapper;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
        this.autorizacaoServico = autorizacaoServico;
        this.tipoFuncionarioServico = tipoFuncionarioServico;
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

    public GerentePorIdResponse buscarPorIdAtualizar(NivelAcesso nivelAcesso, FuncionarioPorIdRequest request) {
        try {
            autorizacaoServico.validaAcessoAdmin(nivelAcesso);
            Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());
            Gerente gerente = tipoFuncionarioServico.validaFuncionarioGerente(funcionario);

            return gerenteMapper.paraResponseGerenteAtualizar(gerente);
        } catch (AutorizacaoException | FuncionarioNaoEhGerenteException | IdNaoEncontradoException e) {
            return gerenteMapper.paraResponseGerenteAtualizar(e.getMessage());
        }
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, GerenteAtualizarRequest request) {
        try {
            autorizacaoServico.validaAcessoAdmin(nivelAcesso);
            Funcionario funcionario = funcionarioRepositorio.buscar(request.id());
            Gerente gerente = tipoFuncionarioServico.validaFuncionarioGerente(funcionario);

            if(request.cpf() != null) {
                CPF cpf = new CPF(request.cpf());

                if(gerente.igualMeuCpf(cpf)) {
                    throw new MesmoDadoException("O cpf deve ser diferente do atual");
                }

                funcionarioServico.cpfUtilizado(cpf);

                gerente.alteraCpf(cpf);
            }

            if(request.nome() != null) {
                NomeFuncionario nome = new NomeFuncionario(request.nome());

                if(gerente.igualMeuNome(nome)) {
                    throw new MesmoDadoException("O nome deve ser diferente do atual");
                }

                gerente.alteraNome(nome);
            }

            if(request.departamentos() != null) {
                ListaDepartamentos departamentos = new ListaDepartamentos(request.departamentos());

                if(gerente.igualMeuDepartamento(departamentos.getListaDepartamentos().getFirst())) {
                    throw new MesmoDadoException("O departamento deve ser diferente do atual");
                }

                gerente.alteraListaDepartamentos(departamentos);
            }

            funcionarioRepositorio.atualizar(gerente);
            return gerenteMapper.paraResponseAtualizar(gerente);
        } catch (AutorizacaoException | FuncionarioException | FuncionarioNaoEhGerenteException |
                 IdNaoEncontradoException | MesmoDadoException e) {
            return gerenteMapper.paraResponseAtualizar(e.getMessage());
        }
    }
}
