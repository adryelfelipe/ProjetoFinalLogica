package Aplicacao.Funcionario.Nucleo.Mapper;

import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Dominio.Funcionario.Nucleo.Funcionario;

public class FuncionarioMapper {
    // Login realizado com sucesso
    public LoginFuncionarioResponse paraLoginResponse(Funcionario funcionario) {
        return new LoginFuncionarioResponse(funcionario.getId(), funcionario.getNivelAcesso(), "Login realizado com sucesso", true);
    }

    // Login falhou
    public LoginFuncionarioResponse paraLoginResponse(String mensagemErro) {
        return new LoginFuncionarioResponse(null, null, mensagemErro, false);
    }

}
