package Dominio.Funcionario.Nucleo.Servicos;

import Dominio.Funcionario.Nucleo.Exceptions.CpfInvalidoException;
import Dominio.Funcionario.Nucleo.Exceptions.IdFuncionarioException;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioQueriesRepositorio;

public class FuncionarioServico {
    // -- Atributos -- //
    private FuncionarioQueriesRepositorio funcionarioRepositorio;

    // -- Construtor -- //
    public FuncionarioServico(FuncionarioQueriesRepositorio funcionarioRepositorio) {
        this.funcionarioRepositorio = funcionarioRepositorio;
    }

    // -- Métodos de validação -- //
    public void cpfUtilizado(CPF cpf) {
        if(funcionarioRepositorio.existeCpf(cpf)) {
            throw new CpfInvalidoException("O cpf informado já foi utilizado");
        }
    }

    public void cpfEncontrado(CPF cpf) {
        if(!funcionarioRepositorio.existeCpf(cpf)) {
            throw new CpfInvalidoException("O cpf informado não foi encontrado");
        }
    }

    public void idEncontrado(long id) {
        if(!funcionarioRepositorio.existeId(id)) {
            throw new IdFuncionarioException("O ID de funcionário informado não foi encontrado");
        }
    }

    public void idUtilizado(long id) {
        if(funcionarioRepositorio.existeId(id)) {
            throw new IdFuncionarioException("O ID de funcionário informado já foi utilizado");
        }
    }
}
