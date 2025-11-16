package Aplicacao.Funcionario.Tecnico.Controller;

import Aplicacao.Funcionario.Gerente.Exceptions.Requests.CadastroGerenteNuloException;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Atualizar.TecnicoAtualizarRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.BuscarPorId.TecnicoPorIdResponse;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Aplicacao.Funcionario.Tecnico.Exceptions.Requests.CadastroTecnicoNuloException;
import Aplicacao.Funcionario.Tecnico.Handler.TecnicoHandler;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class TecnicoController {
    private TecnicoHandler tecnicHandler;

    public TecnicoController(TecnicoHandler tecnicHandler) {
        this.tecnicHandler = tecnicHandler;
    }

    public CadastroTecnicoResponse salvar(NivelAcesso nivelAcesso, CadastroTecnicoRequest request) {
        if(request == null) {
            throw new CadastroTecnicoNuloException();
        }

        return tecnicHandler.salvar(nivelAcesso, request);
    }

    public TecnicoPorIdResponse buscarPorIdUpate(NivelAcesso nivelAcesso, FuncionarioPorIdRequest request) {
        if(request == null) {
            throw new CadastroGerenteNuloException();
        }

        return tecnicHandler.buscarPorId(nivelAcesso, request);
    }

    public AtualizarFuncionarioResponse atualizar(NivelAcesso nivelAcesso, TecnicoAtualizarRequest request) {
        if(request == null) {
            throw new CadastroGerenteNuloException();
        }

        return tecnicHandler.atualizar(nivelAcesso, request);
    }
}
