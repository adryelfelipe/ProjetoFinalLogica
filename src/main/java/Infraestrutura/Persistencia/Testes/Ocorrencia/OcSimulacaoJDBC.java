package Infraestrutura.Persistencia.Testes.Ocorrencia;

import Dominio.Ocorrencia.Ocorrencia;
import Dominio.Ocorrencia.Repositories.OcorrenciaRepositorio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OcSimulacaoJDBC implements OcorrenciaRepositorio {
    public static List<Ocorrencia> listaOcAtivas = new ArrayList<>();
    public static List<Ocorrencia> listaOcGerais = new ArrayList<>();
    private static long qtdOc = 0;


    @Override
    public void salvar(Ocorrencia ocorrencia) {
        qtdOc += 1;
        ocorrencia.alteraIdOcorrencia(qtdOc);
        listaOcAtivas.add(ocorrencia);
        listaOcGerais.add(ocorrencia);
    }

    @Override
    public void atualizar(Ocorrencia ocorrencia) {
        for(Ocorrencia oc : listaOcAtivas) {
            if(oc.getIdOcorrencia() == ocorrencia.getIdOcorrencia()) {
                listaOcAtivas.set(listaOcAtivas.indexOf(oc), ocorrencia);
            }
        }

        for(Ocorrencia oc : listaOcGerais) {
            if(oc.getIdOcorrencia() == ocorrencia.getIdOcorrencia()) {
                listaOcGerais.set(listaOcGerais.indexOf(oc), ocorrencia);
            }
        }
    }

    @Override
    public void excluirPorId(long idOc) {
        Iterator<Ocorrencia> iterator = listaOcAtivas.iterator();
        while (iterator.hasNext()) {
            Ocorrencia oc = iterator.next();
            if (oc.getIdOcorrencia() == idOc) {
                iterator.remove();  // Remove de forma segura
            }
        }
    }


    @Override
    public Ocorrencia buscarPorId(long idOc) {
        for(Ocorrencia oc : listaOcAtivas) {
            if(oc.getIdOcorrencia() == idOc) {
                return oc;
            }
        }

        return null;
    }

    @Override
    public boolean existeOcorrenciaMaquina(long idMaquina) {
        for(Ocorrencia oc : listaOcAtivas) {
            if(oc.getIdMaquina() == idMaquina) {
                return true;
            }
        }

        return false;
    }

    @Override
    public List<Ocorrencia> listarOcAtivas() {
        return listaOcAtivas;
    }

    @Override
    public List<Ocorrencia> listarOcGerais() {
        return listaOcGerais;
    }

    @Override
    public Ocorrencia ocorrenciaPorIdMaquina(long idMaquina) {
        for(Ocorrencia oc : listaOcAtivas) {
            if(oc.getIdMaquina() == idMaquina) {
                return oc;
            }
        }

        return null;
    }
}
