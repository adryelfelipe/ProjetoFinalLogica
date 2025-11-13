package Infraestrutura.Persistencia.Testes.OsSimulacaoJDBC;

import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;

import java.util.ArrayList;

public class OsSimulacaoJDBC implements OrdemDeServicoRepositorio {
    public static ArrayList<OrdemDeServico> listaOs = new ArrayList<>();

    @Override
    public void salvar(OrdemDeServico ordemDeServico) {
        listaOs.add(ordemDeServico);
    }

    @Override
    public void atualizar(OrdemDeServico ordemDeServico) {
        for(OrdemDeServico os : listaOs) {
            if(os.getIdOs() == ordemDeServico.getIdOs()) {
                listaOs.set(listaOs.indexOf(os), ordemDeServico);
            }
        }
    }

    @Override
    public void excluirPorId(long idOs) {
        for(OrdemDeServico os : listaOs) {
            if(os.getIdOs() == idOs) {
                listaOs.remove(os);
            }
        }
    }

    @Override
    public OrdemDeServico buscarPorId(long idOs) {
        for(OrdemDeServico os : listaOs) {
            if(os.getIdOs() == idOs) {
                return os;
            }
        }

        return null;
    }

    @Override
    public boolean existeId(long idOs) {
        for(OrdemDeServico os : listaOs) {
            if(os.getIdOs() == idOs) {
                return true;
            }
        }

        return false;
    }
}
