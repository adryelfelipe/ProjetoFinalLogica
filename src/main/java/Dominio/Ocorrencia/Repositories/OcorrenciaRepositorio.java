package Dominio.Ocorrencia.Repositories;

import Dominio.Maquina.Maquina;
import Dominio.Ocorrencia.Ocorrencia;
import Dominio.OrdemDeServico.OrdemDeServico;

import java.util.List;

public interface OcorrenciaRepositorio {
    void excluirPorId(long id);
    void atualizar(Ocorrencia ocorrencia);
    List<Ocorrencia> listarOcAtivas();
    List<Ocorrencia> listarOcGerais();
    void salvar(Ocorrencia ocorrencia);
    Ocorrencia buscarPorId(long idOc);
    boolean existeOcorrenciaMaquina(long idMaquina);
    Ocorrencia ocorrenciaPorIdMaquina(long idMaquina);
}
