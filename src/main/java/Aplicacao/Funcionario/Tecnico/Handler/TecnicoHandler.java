package Aplicacao.Funcionario.Tecnico.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Aplicacao.Funcionario.Tecnico.Mapper.TecnicoMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Funcionario.Tecnico.Tecnico;

public class TecnicoHandler {
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioServico funcionarioServico;
    private AutorizacaoServico autorizacaoServico;
    private TecnicoMapper tecnicoMapper;

    public TecnicoHandler(FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico, AutorizacaoServico autorizacaoServico, TecnicoMapper tecnicoMapper) {
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
        this.autorizacaoServico = autorizacaoServico;
        this.tecnicoMapper = tecnicoMapper;
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
}
