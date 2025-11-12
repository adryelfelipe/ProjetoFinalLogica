package Aplicacao.Funcionario.Supervisor.Mapper;

import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.Cadastro.CadastroSupervisorResponse;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;
import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Dominio.Funcionario.Supervisor.Supervisor;

public class SupervisorMapper {
    // -- Métodos -- //
    public Supervisor paraEntidade(CadastroSupervisorRequest request) {
        return new Supervisor(new NomeFuncionario(request.nome()),
                new CPF(request.cpf()),
                new Senha(request.senha()),
                new ListaDepartamentos(request.listaDepartamentos()),
                new MetaMensal(request.metaMensal()));
    }

    // -- Métodos -- //

    // Cadastro foi um sucesso
    public CadastroSupervisorResponse paraResponseCadastro(Supervisor supervisor) {
        return new CadastroSupervisorResponse(supervisor.getId(), supervisor.getNome(), true, "Supervisor cadastrado com sucesso!");
    }

    // Cadastro falhou
    public CadastroSupervisorResponse paraResponseCadastro(String mensagemErro) {
        return new CadastroSupervisorResponse(null, null, false, mensagemErro);
    }
}
