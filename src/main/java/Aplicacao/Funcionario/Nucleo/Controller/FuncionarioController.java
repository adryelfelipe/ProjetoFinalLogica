package Aplicacao.Funcionario.Nucleo.Controller;

import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Exceptions.LoginNuloException;
import Aplicacao.Funcionario.Nucleo.Handler.FuncionarioHandler;

public class FuncionarioController {
    // -- Atributos -- //
    private FuncionarioHandler funcionarioHandler;

     // -- Construtor -- //
    public FuncionarioController(FuncionarioHandler funcionarioHandler) {
        this.funcionarioHandler = funcionarioHandler;
    }

    // -- Métodos -- //
    public LoginFuncionarioResponse login(LoginFuncionarioRequest request) {
        if(request == null) {
           throw new LoginNuloException();
        }

        return funcionarioHandler.login(request);
    }
}
