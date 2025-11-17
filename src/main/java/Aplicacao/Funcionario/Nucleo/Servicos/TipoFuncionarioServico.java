package Aplicacao.Funcionario.Nucleo.Servicos;

import Aplicacao.Funcionario.Gerente.Exceptions.Handler.FuncionarioNaoEhGerenteException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.IdFuncionarioNaoEncontradoException;
import Aplicacao.Funcionario.Supervisor.Exceptions.Handler.FuncionarioNaoEhSupervisorException;
import Aplicacao.Funcionario.Tecnico.Exceptions.Handler.FuncionarioNaoEhTecnicoException;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Tecnico;

public class TipoFuncionarioServico {

    // -- Métodos -- //
    public Gerente validaFuncionarioGerente(Funcionario funcionario) {
        if(funcionario == null) {
            throw new IdFuncionarioNaoEncontradoException();
        }

        if(!(funcionario instanceof Gerente)) {
            throw new FuncionarioNaoEhGerenteException();
        }

        return (Gerente) funcionario;
    }

    public Tecnico validaFuncionarioTecnico(Funcionario funcionario) {
        if(funcionario == null) {
            throw new IdFuncionarioNaoEncontradoException();
        }

        if(!(funcionario instanceof Tecnico)) {
            throw new FuncionarioNaoEhTecnicoException();
        }

        return (Tecnico) funcionario;
    }

    public Supervisor validaFuncionarioSupervisor(Funcionario funcionario) {
        if(funcionario == null) {
            throw new IdFuncionarioNaoEncontradoException();
        }

        if(!(funcionario instanceof Supervisor)) {
            throw new FuncionarioNaoEhSupervisorException();
        }

        return (Supervisor) funcionario;
    }
}
