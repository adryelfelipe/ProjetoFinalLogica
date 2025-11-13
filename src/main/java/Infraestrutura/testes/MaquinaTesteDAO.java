package Infraestrutura.testes;

import Dominio.Maquina.Maquina;
import Dominio.Maquina.Repositories.MaquinaRepositorio;

import java.util.ArrayList;

public class MaquinaTesteDAO implements MaquinaRepositorio {
    // -- Atributos -- //
    public static ArrayList<Maquina> listaMaquinas = new ArrayList<>();

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
}
