package Aplicacao.OrdemDeServico.Controller;

import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Exceptions.CadastroOsNulaException;
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
    public void salvar(NivelAcesso nivelAcesso, CadastroOsRequest request) {
        if(request == null) {
            throw new CadastroOsNulaException();
        }

        osHandler.salvar(nivelAcesso, request);
    }
}
