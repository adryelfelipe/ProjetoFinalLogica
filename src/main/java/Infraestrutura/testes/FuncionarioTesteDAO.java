package Infraestrutura.testes;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;

import java.util.ArrayList;

public class FuncionarioTesteDAO implements FuncionarioRepositorio {
    public final ArrayList<Funcionario> funcionarioArrayList = new ArrayList<>();

    @Override
    public boolean existeCpf(CPF cpf) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getCpf().getCpf().equals(cpf.getCpf())) {
               return true;
            }
        }

        return false;
    }

    @Override
    public boolean existeId(long id) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getId() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Funcionario buscarPorId(long id) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getId() == id) {
                return funcionario;
            }
        }

        return null;
    }

    @Override
    public NivelAcesso nivelAcessoPorID(long id) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getId() == id) {
                return funcionario.getNivelAcesso();
            }
        }

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
    public void atualizar(Funcionario funcionarioAtualizado) {
        int cont = 0;

        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getId() == funcionarioAtualizado.getId()) {
                funcionarioArrayList.set(cont, funcionario);
                break;
            }

            cont ++;
        }
    }

    @Override
    public boolean excluirPorId(long id) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getId() == id) {
                funcionarioArrayList.remove(funcionario);
                return true;
            }
        }

        return false;
    }
}
