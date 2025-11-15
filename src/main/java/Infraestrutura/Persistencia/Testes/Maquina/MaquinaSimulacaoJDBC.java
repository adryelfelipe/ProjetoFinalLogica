package Infraestrutura.Persistencia.Testes.Maquina;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Maquina.Maquina;
import Dominio.Maquina.Repositories.MaquinaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class MaquinaSimulacaoJDBC implements MaquinaRepositorio {
    // -- Atributos -- //
    public static ArrayList<Maquina> listaMaquinas = new ArrayList<>();
    private static long qtdMaquinas = 0;

    @Override
    public boolean existeId(long id) {
        for(Maquina maquina : listaMaquinas) {
            if(maquina.getIdMaquina() == id) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void salvar(Maquina maquina) {
        qtdMaquinas += 1;
        maquina.alteraIdMaquina(qtdMaquinas);
        listaMaquinas.add(maquina);
    }

    @Override
    public void excluirPorId(long id) {
        for(Maquina maquina : listaMaquinas) {
            if(maquina.getIdMaquina() == id) {
                listaMaquinas.remove(maquina);
            }
        }
    }

    @Override
    public Maquina buscarPorId(long id) {
        for(Maquina maquina : listaMaquinas) {
            if(maquina.getIdMaquina() == id) {
                return maquina;
            }
        }

        return null;
    }

    @Override
    public void atualizar(Maquina maquinaB) {
        for(Maquina maquinaA : listaMaquinas) {
            if(maquinaA.getIdMaquina() == maquinaB.getIdMaquina()) {
                listaMaquinas.set(listaMaquinas.indexOf(maquinaA), maquinaB);
            }
        }
    }

    @Override
    public List<Maquina> listaMaquinas() {
        return listaMaquinas;
    }

    @Override
    public Departamento maquinaParaDepartamento(long idMaquina) {
        for(Maquina maquina : listaMaquinas) {
            if(maquina.getIdMaquina() == idMaquina) {
                return maquina.getDepartamento();
            }
        }

        return null;
    }
}
