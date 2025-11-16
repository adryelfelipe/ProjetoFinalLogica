package Aplicacao.Funcionario.Nucleo.Servicos;

import Aplicacao.Funcionario.Gerente.Exceptions.Handler.FuncionarioNaoEhGerenteException;
import Aplicacao.Funcionario.Nucleo.Exceptions.Handler.IdNaoEncontradoException;
import Dominio.Funcionario.Gerente.Gerente;
import Dominio.Funcionario.Nucleo.Funcionario;

public class TipoFuncionarioServico {

    // -- Métodos -- //
    public Gerente validaFuncionarioGerente(Funcionario funcionario) {
        if(funcionario == null) {
            throw new IdNaoEncontradoException();
        }

        if(!(funcionario instanceof Gerente)) {
            throw new FuncionarioNaoEhGerenteException();
        }

        return (Gerente) funcionario;
    }
}
