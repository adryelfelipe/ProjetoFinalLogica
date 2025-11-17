package Aplicacao.OrdemDeServico.Controller;

import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Exceptions.Requests.CadastroOsNulaException;
import Aplicacao.OrdemDeServico.Exceptions.Requests.ListarNulaException;
import Aplicacao.OrdemDeServico.Handler.OrdemDeServicoHandler;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class OrdemDeServicoController {
    // -- Atributos -- //
    private OrdemDeServicoHandler osHandler;

    // -- Construtor -- //
    public OrdemDeServicoController(OrdemDeServicoHandler osHandler) {
        this.osHandler = osHandler;
    }

    // -- Métodos -- //
    public CadastroOsResponse salvar(NivelAcesso nivelAcesso, CadastroOsRequest request) {
        if(request == null) {
            throw new CadastroOsNulaException();
        }

        return osHandler.salvar(nivelAcesso, request);
    }

    public ListarOsResponse listarOsDepartamento(NivelAcesso nivelAcesso, ListarOsRequest request) {
        if(request == null) {
            throw new ListarNulaException();
        }

        return osHandler.listarOsDepartamento(nivelAcesso, request);
    }
}
