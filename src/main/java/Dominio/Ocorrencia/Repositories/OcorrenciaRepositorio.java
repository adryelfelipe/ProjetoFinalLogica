package Dominio.Ocorrencia.Repositories;

import Dominio.Maquina.Maquina;
import Dominio.Ocorrencia.Ocorrencia;

import java.util.List;

public interface OcorrenciaRepositorio {
    void excluirPorId(long id);
    Maquina buscarPorId(long id);
    void atualizar(Maquina maquina);
    List<Ocorrencia> listarOcorrencias();
}
