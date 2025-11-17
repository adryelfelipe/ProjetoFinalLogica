package Aplicacao.Funcionario.Supervisor.Controller;

import Aplicacao.Funcionario.Gerente.Exceptions.Requests.CadastroGerenteNuloException;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Exceptions.Requests.BuscarPorIdNuloException;
import Aplicacao.Funcionario.Supervisor.Dtos.Atualizar.AtualizarSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId.SupervisorPorIdResponse;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorResponse;
import Aplicacao.Funcionario.Supervisor.Exceptions.Requests.AtualizarSupervisorNuloException;
import Aplicacao.Funcionario.Supervisor.Exceptions.Requests.CadastroSupervisorNuloException;
import Aplicacao.Funcionario.Supervisor.Handler.SupervisorHandler;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class SupervisorController {
    // -- Atributos -- //
    private SupervisorHandler supervisorHandler;

    // -- Construtor -- //
    public SupervisorController(SupervisorHandler supervisorHandler) {
        this.supervisorHandler = supervisorHandler;
    }

    // -- Métodos -- //
    public CadastroSupervisorResponse salvar(NivelAcesso nivelAcesso, CadastroSupervisorRequest request) {
        if(request == null) {
            throw new CadastroSupervisorNuloException();
        }

        return supervisorHandler.salvar(nivelAcesso, request);
    }

    public SupervisorPorIdResponse buscarPorId(FuncionarioPorIdRequest request) {
        if(request == null) {
            throw new BuscarPorIdNuloException();
        }

        return supervisorHandler.buscarPorId(request);
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, AtualizarSupervisorRequest request) {
        if(request == null) {
            throw new AtualizarSupervisorNuloException();
        }

        return supervisorHandler.atualizar(nivelAcesso, request);
    }
}
