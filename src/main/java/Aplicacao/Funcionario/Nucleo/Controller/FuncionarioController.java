package Aplicacao.Funcionario.Nucleo.Controller;

import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Exceptions.Requests.ExclusaoFuncionarioNulaException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Requests.LoginNuloException;
import Aplicacao.Funcionario.Nucleo.Handler.FuncionarioHandler;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

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

    public ExcluirFuncionarioResponse excluir(NivelAcesso nivelAcesso, ExcluirFuncionarioRequest request) {
        if(request == null) {
            throw new ExclusaoFuncionarioNulaException();
        }

        return funcionarioHandler.excluir(nivelAcesso, request);
    }

    public ListaFuncionariosResponse listaFuncionariosParaAdm(NivelAcesso nivelAcesso) {
        return funcionarioHandler.listarFuncionariosParaAdm(nivelAcesso);
    }

    public ListaFuncionariosResponse listaFuncionariosParaGerente(NivelAcesso nivelAcesso) {
        return funcionarioHandler.listarFuncionariosParaGerente(nivelAcesso);
    }
}
