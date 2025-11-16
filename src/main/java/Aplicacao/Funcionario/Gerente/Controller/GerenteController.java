package Aplicacao.Funcionario.Gerente.Controller;

import Aplicacao.Funcionario.Gerente.Dtos.Atualizar.GerenteAtualizarRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Atualizar.GerenteAtualizarResponse;
import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
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

    public GerentePorIdResponse buscarPorIdUpate(NivelAcesso nivelAcesso, FuncionarioPorIdRequest request) {
        if(request == null) {
            throw new CadastroGerenteNuloException();
        }

        return gerenteHandler.buscarPorIdAtualizar(nivelAcesso, request);
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, GerenteAtualizarRequest request) {
        if(request == null) {
            throw new CadastroGerenteNuloException();
        }

        return gerenteHandler.atualizar(nivelAcesso, request);
    }
}
