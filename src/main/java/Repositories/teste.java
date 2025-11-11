package Repositories;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioQueriesRepositorio;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;

import java.util.ArrayList;

public class teste implements FuncionarioRepositorio, FuncionarioQueriesRepositorio {
    public final ArrayList<Funcionario> funcionarioArrayList = new ArrayList<>();

    @Override
    public boolean existeCpf(CPF cpf) {
        return false;
    }

    @Override
    public boolean existeId(long id) {
        return false;
    }

    @Override
    public Funcionario buscarPorId(long id) {
        return null;
    }

    @Override
    public NivelAcesso nivelAcessoPorID(long id) {
        return null;
    }

    @Override
    public Funcionario buscarPorCpf(CPF cpf) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getCpf().getCpf().equals(cpf.getCpf())) {
                return funcionario;
            }
        }

        return null;
    }

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarioArrayList.add(funcionario);
    }

    @Override
    public void atualizar(Funcionario funcionario) {

    }

    @Override
    public boolean excluirPorId(long id) {
        return false;
    }
}
