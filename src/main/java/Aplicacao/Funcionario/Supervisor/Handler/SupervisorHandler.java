package Aplicacao.Funcionario.Supervisor.Handler;

import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.AutorizacaoException;
import Aplicacao.Funcionario.Nucleo.Servicos.AutorizacaoServico;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorResponse;
import Aplicacao.Funcionario.Supervisor.Mapper.SupervisorMapper;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Exceptions.FuncionarioException;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Funcionario.Supervisor.Supervisor;

public class SupervisorHandler {
    // -- Atributos -- //
    private SupervisorMapper supervisorMapper;
    private FuncionarioRepositorio funcionarioRepositorio;
    private FuncionarioServico funcionarioServico;
    private AutorizacaoServico autorizacaoServico;

    // -- Construtor -- //
    public SupervisorHandler(SupervisorMapper supervisorMapper, FuncionarioRepositorio funcionarioRepositorio, FuncionarioServico funcionarioServico, AutorizacaoServico autorizacaoServico) {
        this.supervisorMapper = supervisorMapper;
        this.funcionarioRepositorio = funcionarioRepositorio;
        this.funcionarioServico = funcionarioServico;
        this.autorizacaoServico = autorizacaoServico;
    }

    // -- Métodos -- //
    public CadastroSupervisorResponse salvar(NivelAcesso nivelAcesso, CadastroSupervisorRequest request) {
        try {
            autorizacaoServico.validaAcessoGerente(nivelAcesso);
            Supervisor supervisor = supervisorMapper.paraEntidade(request);
            funcionarioServico.cpfUtilizado(supervisor.getCpf());
            funcionarioServico.idUtilizado(supervisor.getId());
            funcionarioRepositorio.salvar(supervisor);
            return supervisorMapper.paraResponseCadastro(supervisor);
        } catch (AutorizacaoException | FuncionarioException e) {
            return supervisorMapper.paraResponseCadastro(e.getMessage());
        }

    }
}
