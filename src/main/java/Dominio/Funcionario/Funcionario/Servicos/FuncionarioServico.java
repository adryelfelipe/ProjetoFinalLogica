package Dominio.Funcionario.Funcionario.Servicos;

import Dominio.Funcionario.Funcionario.Exceptions.CpfInvalidoException;
import Dominio.Funcionario.Funcionario.Exceptions.IdFuncionarioException;
import Dominio.Funcionario.Funcionario.ObjetosDeValor.CPF;
import Dominio.Funcionario.Funcionario.Repositorios.FuncionarioQueriesRepositorio;

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

    public void existeCpf(CPF cpf) {
        if(funcionarioRepositorio.existeCpf(cpf)) {

        }
    }

    public void existeID(long id) {
        if(!funcionarioRepositorio.existeID(id)) {
            throw new IdFuncionarioException("O ID informado não foi encontrado");
        }
    }
}
