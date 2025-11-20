package Infraestrutura.Persistencia.Testes.Funcionario;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Funcionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.Funcionario.Tecnico.Tecnico;
import Infraestrutura.Persistencia.Testes.OrdemDeServico.OsSimulacaoJDBC;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FuncionarioSimulacaoJDBC implements FuncionarioRepositorio {
    public final ArrayList<Funcionario> funcionarioArrayList = new ArrayList<>();
    private static long qtdFuncionarios = 0;

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
    public Funcionario buscar(long id) {
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
    public Funcionario buscar(CPF cpf) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getCpf().getCpf().equals(cpf.getCpf())) {
                return funcionario;
            }
        }

        return null;
    }

    @Override
    public List<Funcionario> listarFuncionarios() {
        return funcionarioArrayList;
    }

    @Override
    public void salvar(Funcionario funcionario) {
        qtdFuncionarios += 1;
        funcionario.alteraIdFuncionario(qtdFuncionarios);
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
    public boolean excluir(long id) {

        Iterator<Funcionario> it = funcionarioArrayList.iterator();

        while (it.hasNext()) {
            Funcionario funcionario = it.next();

            // Verifica se é o funcionário a ser removido
            if (funcionario instanceof Tecnico tecnico && tecnico.getId() == id) {

                // Remove o técnico
                it.remove();

                // Remove as OS vinculadas ao técnico
                OsSimulacaoJDBC.listaOsTodas.removeIf(
                        os -> os.getIdTecnico() == id
                );

                return true;
            }

            if (funcionario instanceof Supervisor supervisor && supervisor.getId() == id) {

                // Remove o supervisor
                it.remove();

                // Remove as OS vinculadas ao supervisor
                OsSimulacaoJDBC.listaOsTodas.removeIf(
                        os -> os.getIdSupervisor() == id
                );

                return true;
            }
        }

        return false;
    }

    @Override
    public NomeFuncionario buscarNome(long id) {
        for(Funcionario funcionario : funcionarioArrayList) {
            if(funcionario.getId() == id) {
                return funcionario.getNome();
            }
        }

        return null;
    }
}
