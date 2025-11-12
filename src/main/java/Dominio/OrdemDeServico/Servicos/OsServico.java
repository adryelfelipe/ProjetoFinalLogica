package Dominio.OrdemDeServico.Servicos;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Repositorios.FuncionarioRepositorio;
import Dominio.Funcionario.Nucleo.Servicos.FuncionarioServico;
import Dominio.Maquina.Repositories.MaquinaRepositorio;
import Dominio.Maquina.Servicos.MaquinaServico;
import Dominio.OrdemDeServico.Exceptions.IdMaquinaOsException;
import Dominio.OrdemDeServico.Exceptions.IdOsException;
import Dominio.OrdemDeServico.Exceptions.IdSupervisorOsException;
import Dominio.OrdemDeServico.Exceptions.IdTecnicoOsException;
import Dominio.OrdemDeServico.Repositorios.OrdemDeServicoRepositorio;

public class OsServico {
    // -- Atributos -- //
    private MaquinaRepositorio maquinaRepositorio;
    private OrdemDeServicoRepositorio ordemDeServicoRepositorio;
    private FuncionarioRepositorio funcionarioRepositorio;

    // -- Construtor -- //
    public OsServico(MaquinaRepositorio maquinaRepositorio) {
        this.maquinaRepositorio = maquinaRepositorio;
    }

    public void idUtilizado(long idOs) {
        if(ordemDeServicoRepositorio.existeId(idOs)) {
            throw new IdOsException("O ID da ordem de serviço informado já foi utilizado");
        }
    }

    public void tecnicoPertenceAoDepartamento(long idTenico, Departamento departamento) {
        if(!funcionarioRepositorio.buscarPorId(idTenico).igualMeuDepartamento(departamento)) {
            throw new IdTecnicoOsException("O técnico indicado não pode operar neste departamento");
        }
    }

    public void supervisorPertenceAoDepartamento(long idSupervisor, Departamento departamento) {
        if(!funcionarioRepositorio.buscarPorId(idSupervisor).igualMeuDepartamento(departamento)) {
            throw new IdSupervisorOsException("O supervisor indicado não pode operar neste departamento");
        }
    }

    public void tecnicoExiste(long idTecnico) {
        if(!funcionarioRepositorio.existeId(idTecnico) || funcionarioRepositorio.buscarPorId(idTecnico).getNivelAcesso() != NivelAcesso.TECNICO) {
            throw new IdTecnicoOsException("O téncico indicado para a operação não foi encontrado");
        }
    }

    public void supervisorExiste(long idSupervisor) {
        if(!funcionarioRepositorio.existeId(idSupervisor) || funcionarioRepositorio.buscarPorId(idSupervisor).getNivelAcesso() != NivelAcesso.SUPERVISOR) {
            throw new IdSupervisorOsException("O supervisor indicado para a operação não foi encontrado");
        }
    }

    public void maquinaExiste(long idMaquina) {
        if(!maquinaRepositorio.existeId(idMaquina)) {
            throw new IdMaquinaOsException("A máquina indicada para a operação não foi encontrada");
        }
    }
}
