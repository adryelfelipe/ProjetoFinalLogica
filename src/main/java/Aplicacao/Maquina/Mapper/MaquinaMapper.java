package Aplicacao.Maquina.Mapper;

import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Maquina.Dtos.Atualizar.AtualizarMaquinaResponse;
import Aplicacao.Maquina.Dtos.BuscarPorId.MaquinaPorIdRequest;
import Aplicacao.Maquina.Dtos.BuscarPorId.MaquinaPorIdResponse;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Aplicacao.Maquina.Dtos.Listar.ListaMaquinasResponse;
import Aplicacao.Maquina.Dtos.Listar.MaquinaResponse;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

import java.util.ArrayList;
import java.util.List;

public class MaquinaMapper {
    public Maquina paraEntidade(CadastroMaquinaRequest request) {
        return new Maquina(new NomeMaquina(request.nome()), request.departamento(), request.status());
    }

    // Cadastro foi um sucesso
    public CadastroMaquinaResponse paraResponseCadastro(Maquina maquina) {
        return new CadastroMaquinaResponse(maquina.getIdMaquina(), maquina.getNome(), true, "✅ Cadastro realizado com sucesso!");
    }

    // Cadastro falhou
    public CadastroMaquinaResponse paraResponseCadastro(String mensagem) {
        return new CadastroMaquinaResponse(null, null,false, mensagem);
    }

    // Listagem de máquinas foi um sucesso
    public ListaMaquinasResponse paraListaResponse(List<Maquina> listaMaquinas) {
        List<MaquinaResponse> listaMaquinasResponse = new ArrayList<>();

        for(Maquina maquina : listaMaquinas) {
            listaMaquinasResponse.add(new MaquinaResponse(maquina.getIdMaquina(), maquina.getNome()));
        }

        return new ListaMaquinasResponse(listaMaquinasResponse, true, "✅ Listagem realizada com sucesso");
    }

    // Listagem de máquinas falhou
    public ListaMaquinasResponse paraListaResponse(String mensagem) {
        return new ListaMaquinasResponse(null, false, mensagem);
    }

    // Busca por ID foi um sucesso
    public MaquinaPorIdResponse paraMaquinaPorIdResponse(Maquina maquina) {
        return new MaquinaPorIdResponse(maquina.getIdMaquina(), maquina.getNome(), maquina.getStatus(), maquina.getDepartamento(), true, "✅ Busca realizada por ID com sucesso");
    }

    // Busca por ID falhou
    public MaquinaPorIdResponse paraMaquinaPorIdResponse(String mensagem) {
        return new MaquinaPorIdResponse(null, null, null, null, false, mensagem);
    }

    // Atualização foi um sucesso
    public AtualizarMaquinaResponse paraAtualizarResponse(Maquina maquina) {
        return new AtualizarMaquinaResponse(maquina.getIdMaquina(),true, "✅ Máquina atualizada com sucesso");
    }

    // Atualização falhou
    public AtualizarMaquinaResponse paraAtualizarResponse(String mensagem) {
        return new AtualizarMaquinaResponse(null,false, mensagem);
    }
}
