package Aplicacao.Funcionario.Gerente.Controller;

import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Aplicacao.Funcionario.Gerente.Exceptions.CadastroGerenteNuloException;
import Aplicacao.Funcionario.Gerente.Handler.GerenteHandler;
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
}
