package Aplicacao.Funcionario.Tecnico.Handler;

import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.*;
import Aplicacao.Funcionario.Nucleo.Mapper.FuncionarioMapper;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Nucleo.Servicos.TipoFuncionarioServico;
import Aplicacao.Funcionario.Tecnico.Dtos.Atualizar.TecnicoAtualizarRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.BuscarPorId.TecnicoPorIdResponse;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Aplicacao.Funcionario.Tecnico.Exceptions.Handler.FuncionarioNaoEhTecnicoException;
import Aplicacao.Funcionario.Tecnico.Mapper.TecnicoMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Exceptions.MesmoCpfFuncionarioException;
import Dominio.Funcionario.Nucleo.Exceptions.MesmoDadoFuncionarioException;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Funcionario.Tecnico.Tecnico;

public class TecnicoHandler {
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioServico funcionarioServico;
    private AutorizacaoServico autorizacaoServico;
    private TecnicoMapper tecnicoMapper;
    private TipoFuncionarioServico tipoFuncionarioServico;
    private FuncionarioMapper funcionarioMapper;

    public TecnicoHandler(FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico, AutorizacaoServico autorizacaoServico, TecnicoMapper tecnicoMapper, TipoFuncionarioServico tipoFuncionarioServico, FuncionarioMapper funcionarioMapper) {
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
        this.autorizacaoServico = autorizacaoServico;
        this.tecnicoMapper = tecnicoMapper;
        this.tipoFuncionarioServico = tipoFuncionarioServico;
        this.funcionarioMapper = funcionarioMapper;
    }

    public CadastroTecnicoResponse salvar(NivelAcesso nivelAcesso, CadastroTecnicoRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Tecnico tecnico = tecnicoMapper.paraEntidade(request);
            funcionarioServico.cpfUtilizado(tecnico.getCpf());
            funcionarioRepositorio.salvar(tecnico);
            return tecnicoMapper.paraResponseCadastro(tecnico);
        } catch (FuncionarioException | AutorizacaoException e) {
            return tecnicoMapper.paraResponseCadastro(e.getMessage());
        }
    }

    public TecnicoPorIdResponse buscarPorId(FuncionarioPorIdRequest request) {
        try {
            Funcionario funcionario = funcionarioRepositorio.buscar(request.idFuncionario());
            Tecnico tenico = tipoFuncionarioServico.validaFuncionarioTecnico(funcionario);

            return tecnicoMapper.paraResponseTecnico(tenico);
        } catch (FuncionarioNaoEhTecnicoException | IdFuncionarioNaoEncontradoException e) {
            return tecnicoMapper.paraResponseTecnico(e.getMessage());
        }
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, TecnicoAtualizarRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Funcionario funcionario = funcionarioRepositorio.buscar(request.id());
            Tecnico tecnico = tipoFuncionarioServico.validaFuncionarioTecnico(funcionario);

            if(request.cpf() != null) {
                CPF cpf = new CPF(request.cpf());
                funcionarioServico.cpfUtilizado(cpf);
                tecnico.alteraCpf(cpf);
            }

            if(request.nome() != null) {
                NomeFuncionario nome = new NomeFuncionario(request.nome());
                tecnico.alteraNome(nome);
            }

            if(request.departamentos() != null) {
                ListaDepartamentos departamentos = new ListaDepartamentos(request.departamentos());
                tecnico.alteraListaDepartamentos(departamentos);
            }

            if(request.especialidade() != null) {
                tecnico.alteraEspecialidade(request.especialidade());
            }

            funcionarioRepositorio.atualizar(tecnico);
            return funcionarioMapper.paraResponseAtualizar(tecnico);
        } catch (AutorizacaoException | FuncionarioException | FuncionarioNaoEhTecnicoException |
                 IdFuncionarioNaoEncontradoException | MesmoDadoFuncionarioException e) {
            return funcionarioMapper.paraResponseAtualizar(e.getMessage());
        }
    }
}
