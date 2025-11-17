package Aplicacao.Funcionario.Gerente.Controller;

import Aplicacao.Funcionario.Gerente.Dtos.Atualizar.AtualizarGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.Exceptions.Requests.AtualizarGerenteNuloException;
import Aplicacao.Funcionario.Gerente.Exceptions.Requests.CadastroGerenteNuloException;
import Aplicacao.Funcionario.Gerente.Handler.GerenteHandler;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class GerenteController {
    // -- Atributos -- //
    private GerenteHandler gerenteHandler;

    // -- Construtor -- //
    public GerenteController(GerenteHandler gerenteHandler) {
        this.gerenteHandler = gerenteHandler;
    }

    // -- Métodos -- //
    public CadastroGerenteResponse salvar(NivelAcesso nivelAcesso, CadastroGerenteRequest request) {
        if(request == null) {
            throw new CadastroGerenteNuloException();
        }

        return gerenteHandler.cadastrar(nivelAcesso, request);
    }

    public GerentePorIdResponse buscarPorId(NivelAcesso nivelAcesso, FuncionarioPorIdRequest request) {
        if(request == null) {
            throw new CadastroGerenteNuloException();
        }

        return gerenteHandler.buscarPorId(nivelAcesso, request);
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, AtualizarGerenteRequest request) {
        if(request == null) {
            throw new AtualizarGerenteNuloException();
        }

        return gerenteHandler.atualizar(nivelAcesso, request);
    }
}
