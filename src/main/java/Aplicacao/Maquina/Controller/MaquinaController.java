package Aplicacao.Maquina.Controller;

import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Aplicacao.Maquina.Exceptions.Requests.CadastroMaquinaNulaException;
import Aplicacao.Maquina.Handler.MaquinaHandler;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class MaquinaController {
    // -- Atributos -- //
    private MaquinaHandler maquinaHandler;

    // -- Construtor -- //
    public MaquinaController(MaquinaHandler maquinaHandler) {
        this.maquinaHandler = maquinaHandler;
    }

    // -- Métodos -- //
    public CadastroMaquinaResponse salvar(NivelAcesso nivelAcesso, CadastroMaquinaRequest request) {
        if(request == null) {
            throw new CadastroMaquinaNulaException();
        }

        return maquinaHandler.salvar(nivelAcesso, request);
    }
}
