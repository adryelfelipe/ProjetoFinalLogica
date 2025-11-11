package Dominio.OrdemDeServico.Repositorios;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.OrdemDeServico;

public interface OrdemDeServicoRepositorio {
    void salvar(OrdemDeServico ordemDeServico);
    void atualizar(OrdemDeServico ordemDeServico);
    void excluirPorId(long idOs);
    OrdemDeServico buscarPorId(long idOs);
    boolean existeId(long idOs);
    boolean tecnicoPertenceAoDepartamento(long idTecnico, Departamento departamento);
    boolean supervisorPertenceAoDepartamento(long idSupervisor, Departamento departamento);
}
