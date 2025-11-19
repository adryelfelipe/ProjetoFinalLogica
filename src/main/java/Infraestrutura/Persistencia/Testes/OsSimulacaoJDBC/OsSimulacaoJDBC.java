package Infraestrutura.Persistencia.Testes.OsSimulacaoJDBC;

import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OsSimulacaoJDBC implements OrdemDeServicoRepositorio {
    public static ArrayList<OrdemDeServico> listaOsAtivas = new ArrayList<>();
    public static ArrayList<OrdemDeServico> listaOsTodas = new ArrayList<>();
    private static long qtdOs = 0;

    @Override
    public void salvar(OrdemDeServico ordemDeServico) {
        qtdOs += 1;
        ordemDeServico.alteraIdOS(qtdOs);
        listaOsAtivas.add(ordemDeServico);
        listaOsTodas.add(ordemDeServico);
    }

    @Override
    public void atualizar(OrdemDeServico ordemDeServico) {
        for(OrdemDeServico os : listaOsAtivas) {
            if(os.getIdOs() == ordemDeServico.getIdOs()) {
                listaOsAtivas.set(listaOsAtivas.indexOf(os), ordemDeServico);
            }
        }

        for(OrdemDeServico os : listaOsTodas) {
            if(os.getIdOs() == ordemDeServico.getIdOs()) {
                listaOsTodas.set(listaOsTodas.indexOf(os), ordemDeServico);
            }
        }
    }

    @Override
    public void excluirPorId(long idOs) {
        Iterator<OrdemDeServico> iterator = listaOsAtivas.iterator();
        while (iterator.hasNext()) {
            OrdemDeServico os = iterator.next();
            if (os.getIdOs() == idOs) {
                iterator.remove();  // Remove de forma segura
            }
        }
    }


    @Override
    public OrdemDeServico buscarPorId(long idOs) {
        for(OrdemDeServico os : listaOsAtivas) {
            if(os.getIdOs() == idOs) {
                return os;
            }
        }

        return null;
    }

    @Override
    public boolean existeId(long idOs) {
        for(OrdemDeServico os : listaOsAtivas) {
            if(os.getIdOs() == idOs) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<OrdemDeServico> listarOsAtivas() {
        return listaOsAtivas;
    }

    @Override
    public List<OrdemDeServico> listarOsTodas() {
        return listaOsTodas;
    }
}
