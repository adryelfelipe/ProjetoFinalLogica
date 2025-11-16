package Aplicacao.Funcionario.Gerente.Mapper;

import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteRequest;
import Aplicacao.Funcionario.Gerente.Dtos.Cadastro.CadastroGerenteResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;

public class GerenteMapper {
    // Transforma request de cadastro em entidade
    public Gerente paraEntidade(CadastroGerenteRequest request) {
        return new Gerente(new NomeFuncionario(request.nomeFuncionario()),
                new CPF(request.cpf()),
                new Senha(request.senha()),
                new ListaDepartamentos(request.listaDepartamentos()));
    }

    // Cadastro foi um sucesso
    public CadastroGerenteResponse paraResponseCadastro(Gerente gerente) {
        return new CadastroGerenteResponse(gerente.getId(), gerente.getNome(), true, "✅ Cadastro realizado com sucesso");
    }

    // Cadastro falhou
    public CadastroGerenteResponse paraResponseCadastro(String mensagemErro) {
        return new CadastroGerenteResponse(null, null,false, mensagemErro);
    }

    // Busca por ID para update foi um sucesso
    public GerentePorIdResponse paraResponseGerente(Gerente gerente) {
        return new GerentePorIdResponse(gerente.getId(),gerente.getNome(), gerente.getCpf(), gerente.getDepartamentos(), true, "✅ Busca realizada por ID com sucesso");
    }

    // Busca por ID para update falhou
    public GerentePorIdResponse paraResponseGerente(String mensagem) {
        return new GerentePorIdResponse(-1, null, null, null,false, mensagem);
    }
}
