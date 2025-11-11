package Aplicacao.Funcionario.Supervisor.Controller;

import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorRequest;
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
    public void salvar(NivelAcesso nivelAcesso, CadastroSupervisorRequest request) {
        supervisorHandler.salvar(nivelAcesso, request);
    }
}
