package Aplicacao.Funcionario.Gerente;

import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Dtos.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.CasosDeUso.CadastrarGerente.Handler.CadastroGerenteHandler;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;

public class GerenteController {
    // -- Atributos -- //
    private CadastroGerenteHandler cadastroGerenteHandler;

    // -- Construtor -- //
    public GerenteController(CadastroGerenteHandler cadastroGerenteHandler) {
        this.cadastroGerenteHandler = cadastroGerenteHandler;
    }

    // -- Métodos -- //
    public CadastroGerenteResponse salvar(CadastroGerenteRequest request) {
        return cadastroGerenteHandler.cadastrarGerente(request);
    }
}
