package Aplicacao.Maquina.Mapper;

import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Aplicacao.Maquina.Dtos.Listar.ListaMaquinasResponse;
import Aplicacao.Maquina.Dtos.Listar.MaquinaResponse;
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
        return new CadastroMaquinaResponse(maquina.getIdMaquina(), maquina.getNome(), true, "Cadastro realizado com sucesso!");
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

        return new ListaMaquinasResponse(listaMaquinasResponse, true, "Listagem bem sucedida");
    }

    // Listagem de máquinas falhou
    public ListaMaquinasResponse paraListaResponse(String mensagem) {
        return new ListaMaquinasResponse(null, false, mensagem);
    }
}
