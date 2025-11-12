package Aplicacao.Maquina.Mapper;

import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaRequest;
import Aplicacao.Maquina.Dtos.Cadastro.CadastroMaquinaResponse;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.ObjetosDeValor.Localizacao;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;

public class MaquinaMapper {
    public Maquina paraEntidade(CadastroMaquinaRequest request) {
        return new Maquina(new NomeMaquina(request.nome()), new Localizacao(request.localizacao()), request.status());
    }

    // Cadastro foi um sucesso
    public CadastroMaquinaResponse paraResponseCadastro(Maquina maquina) {
        return new CadastroMaquinaResponse(maquina.getIdMaquina(), maquina.getNome(), true, "Cadastro realizado com sucesso!");
    }

    // Cadastro falhou
    public CadastroMaquinaResponse paraResponseCadastro(String mensagem) {
        return new CadastroMaquinaResponse(null, null,false, mensagem);
    }
}
