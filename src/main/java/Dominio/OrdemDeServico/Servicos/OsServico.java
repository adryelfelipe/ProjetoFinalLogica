package Dominio.OrdemDeServico.Servicos;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Maquina.Repositories.MaquinaRepositorio;
import Dominio.Maquina.Servicos.MaquinaServico;
import Dominio.OrdemDeServico.Exceptions.IdMaquinaOsException;
import Dominio.OrdemDeServico.Exceptions.IdSupervisorOsException;
import Dominio.OrdemDeServico.Exceptions.IdTecnicoOsException;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;

public class OsServico {
    // -- Atributos -- //
    private MaquinaRepositorio maquinaRepositorio;
    private FuncionarioServico funcionarioServico;
    private OrdemDeServicoRepositorio ordemDeServicoRepositorio;

    // -- Construtor -- //
    public OsServico(MaquinaRepositorio maquinaRepositorio, FuncionarioServico funcionarioServico) {
        this.maquinaRepositorio = maquinaRepositorio;
        this.funcionarioServico = funcionarioServico;
    }

    public void tecnicoPertenceAoDepartamento(long idTenico, Departamento departamento) {
        if(!ordemDeServicoRepositorio.tecnicoPertenceAoDepartamento(idTenico, departamento)) {
            throw new IdTecnicoOsException("O técnico indicado não pode operar neste departamento");
        }
    }

    public void supervisorPertenceAoDepartmaneto(long idSupervisor, Departamento departamento) {
        if(!ordemDeServicoRepositorio.supervisorPertenceAoDepartamento(idSupervisor, departamento)) {
            throw new IdSupervisorOsException("O supervisor indicado não pode operar neste departamento");
        }
    }

    public void tecnicoExiste(long idTecnico) {
        if(!ordemDeServicoRepositorio.existeId(idTecnico)) {
            throw new IdTecnicoOsException("O téncico indicado para a operação não foi encontrado");
        }
    }

    public void supervisorExiste(long idSupervisor) {
        if(!ordemDeServicoRepositorio.existeId(idSupervisor)) {
            throw new IdSupervisorOsException("O supervisor indicado para a operação não foi encontrado");
        }
    }

    public void maquinaExiste(long idMaquina) {
        if(!maquinaRepositorio.existeId(idMaquina)) {
            throw new IdMaquinaOsException("A máquina indicada para a operação não foi encontrada");
        }
    }
}
