package Aplicacao.Funcionario.Nucleo.Mapper;

import Aplicacao.Funcionario.Nucleo.Dtos.Excluir.ExcluirFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Login.LoginFuncionarioResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioMapper {
    // Login realizado com sucesso
    public LoginFuncionarioResponse paraLoginResponse(Funcionario funcionario) {
        return new LoginFuncionarioResponse(funcionario.getId(), funcionario.getNivelAcesso(), "✅ Login realizado com sucesso", true);
    }

    // Login falhou
    public LoginFuncionarioResponse paraLoginResponse(String mensagemErro) {
        return new LoginFuncionarioResponse(null, null, mensagemErro, false);
    }

    public ExcluirFuncionarioResponse paraExcluirResponse(String mensagem, boolean status) {
        return new ExcluirFuncionarioResponse(mensagem, status);
    }

    public ListaFuncionariosResponse paraListaResponseAdm(List<Funcionario> listaFuncionarios) {
        List<FuncionarioResponse> listaFuncionariosResponse = new ArrayList<>();

        for(Funcionario funcionario : listaFuncionarios) {
            if(funcionario.getNivelAcesso() != NivelAcesso.ADMIN) {
                FuncionarioResponse funcionarioResponse = new FuncionarioResponse(funcionario.getId(), funcionario.getNome(), funcionario.getNivelAcesso());
                listaFuncionariosResponse.add(funcionarioResponse);
            }
        }

        return new ListaFuncionariosResponse(listaFuncionariosResponse, true);
    }

    public ListaFuncionariosResponse paraListaResponseGerente(List<Funcionario> listaFuncionarios) {
        List<FuncionarioResponse> listaFuncionariosResponse = new ArrayList<>();

        for(Funcionario funcionario : listaFuncionarios) {
            if(!funcionario.souAdministrador() && !funcionario.souGerente()) {
                FuncionarioResponse funcionarioResponse = new FuncionarioResponse(funcionario.getId(), funcionario.getNome(), funcionario.getNivelAcesso());
                listaFuncionariosResponse.add(funcionarioResponse);
            }
        }

        return new ListaFuncionariosResponse(listaFuncionariosResponse, true);
    }
}
