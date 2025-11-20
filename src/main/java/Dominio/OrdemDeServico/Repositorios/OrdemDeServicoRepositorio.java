package Dominio.OrdemDeServico.Repositorios;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.OrdemDeServico;

import java.util.List;

public interface OrdemDeServicoRepositorio {
    void salvar(OrdemDeServico ordemDeServico);
    void atualizar(OrdemDeServico ordemDeServico);
    void excluirPorId(long idOs);
    OrdemDeServico buscarPorId(long idOs);
    boolean existeId(long idOs);
    List<OrdemDeServico> listarOsAtivas();
    List<OrdemDeServico> listarOsTodas();
    int numeroOrdensMaquina(long idMaquina);
}
