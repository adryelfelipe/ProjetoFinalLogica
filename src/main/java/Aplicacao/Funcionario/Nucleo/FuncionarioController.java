package Aplicacao.Funcionario.Nucleo;

import Aplicacao.Funcionario.Nucleo.CasosDeUso.Login.Dtos.LoginFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.CasosDeUso.Login.Handler.LoginFuncionarioHandler;

public class FuncionarioController {
    // -- Atributos -- //
    private LoginFuncionarioHandler loginFuncionarioHandler;

    // -- Construtor -- //
    public FuncionarioController(LoginFuncionarioHandler loginFuncionarioHandler) {
        this.loginFuncionarioHandler = loginFuncionarioHandler;
    }

    // -- Métodos -- //
    public LoginFuncionarioResponse login() {
        loginFuncionarioHandler.
    }
}
