package Aplicacao.Maquina.Controller;

import Aplicacao.Maquina.Dtos.Atualizar.AtualizarMaquinaRequest;
import Aplicacao.Maquina.Dtos.Atualizar.AtualizarMaquinaResponse;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Aplicacao.Maquina.Dtos.Exclusao.ExcluirMaquinaRequest;
import Aplicacao.Maquina.Dtos.Exclusao.ExcluirMaquinaResponse;
import Aplicacao.Maquina.Dtos.Listar.ListaMaquinasResponse;
import Aplicacao.Maquina.Exceptions.Requests.AtualizarMaquinaNulaException;
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

    public AtualizarMaquinaResponse atualizar(NivelAcesso nivelAcesso, AtualizarMaquinaRequest request) {
        if(request == null) {
            throw new AtualizarMaquinaNulaException();
        }

        return maquinaHandler.atualizar(nivelAcesso, request);
    }

    public ListaMaquinasResponse listarMaquinas(NivelAcesso nivelAcesso) {
        return maquinaHandler.listarMaquinas(nivelAcesso);
    }

    public ExcluirMaquinaResponse excluir(NivelAcesso nivelAcesso, ExcluirMaquinaRequest request) {
        return maquinaHandler.excluir(nivelAcesso, request);
    }
}
