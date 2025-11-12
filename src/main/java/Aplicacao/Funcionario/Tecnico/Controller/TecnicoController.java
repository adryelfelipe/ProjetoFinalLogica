package Aplicacao.Funcionario.Tecnico.Controller;

import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Aplicacao.Funcionario.Tecnico.Handler.TecnicoHandler;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;

public class TecnicoController {
    private TecnicoHandler tecnicHandler;

    public TecnicoController(TecnicoHandler tecnicHandler) {
        this.tecnicHandler = tecnicHandler;
    }

    public CadastroTecnicoResponse salvar(NivelAcesso nivelAcesso, CadastroTecnicoRequest request) {
        return tecnicHandler.salvar(nivelAcesso, request);
    }
}
