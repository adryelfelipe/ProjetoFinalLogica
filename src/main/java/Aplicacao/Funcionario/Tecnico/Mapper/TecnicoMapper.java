package Aplicacao.Funcionario.Tecnico.Mapper;

import Aplicacao.Funcionario.Tecnico.Dtos.BuscarPorId.TecnicoPorIdResponse;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.Cadastro.CadastroTecnicoResponse;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Tecnico.Tecnico;

public class TecnicoMapper {
    public Tecnico paraEntidade(CadastroTecnicoRequest request) {
        return new Tecnico(new NomeFuncionario(request.nome()),
                new CPF(request.cpf()),
                new Senha(request.senha()),
                new ListaDepartamentos(request.departamentos()),
                request.especialidade());
    }

    // Cadastro foi um sucesso
    public CadastroTecnicoResponse paraResponseCadastro(Tecnico tecnico) {
        return new CadastroTecnicoResponse(tecnico.getId(), tecnico.getNome(), true, "✅ Cadastro realizado com sucesso");
    }

    // Cadastro falhou
    public CadastroTecnicoResponse paraResponseCadastro(String mensagem) {
        return new CadastroTecnicoResponse(null, null, false, mensagem);
    }

    // Busca por ID para update foi um sucesso
    public TecnicoPorIdResponse paraResponseTecnico(Tecnico tecnico) {
        return new TecnicoPorIdResponse(tecnico.getId(),tecnico.getNome(), tecnico.getCpf(), tecnico.getDepartamentos(),tecnico.getEspecialidade(), true, "✅ Busca realizada por ID com sucesso");
    }

    // Busca por ID para update falhou
    public TecnicoPorIdResponse paraResponseTecnico(String mensagem) {
        return new TecnicoPorIdResponse(-1, null, null, null,null,false, mensagem);
    }
}
