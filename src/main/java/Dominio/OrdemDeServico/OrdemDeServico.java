package Dominio.OrdemDeServico;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.OrdemDeServico.Exceptions.IdTecnicoOsException;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Exceptions.*;
import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;

public class OrdemDeServico
{
    //--------------------  ATRIBUTOS  --------------------//
    private StatusOS statusOS;
    private Long idOS;
    private Descricao descricao;
    private long idMaquina;
    private long idTecnico;
    private long idSupervisor;
    private Departamento departamento;
    private ValorOS valorOS;

    //--------------------  CONSTRUTOR COM ID --------------------//
    public OrdemDeServico(long idOS, long idTecnico, long idSupervisor, long idMaquina, StatusOS statusOS, Descricao descricao, ValorOS valorOS, Departamento departamento) {
        alteraIdOS(idOS);
        alteraIdTecnico(idTecnico);
        alteraIdSupervisor(idSupervisor);
        alteraIdMaquina(idMaquina);
        alteraStatusOS(statusOS);
        alteraDescricao(descricao);
        alteraValorOS(valorOS);
        alteraDepartamento(departamento);
    }

    //--------------------  CONSTRUTOR SEM ID --------------------//
    public OrdemDeServico(long idTecnico, long idSupervisor, long idMaquina, StatusOS statusOS, Descricao descricao, ValorOS valorOS, Departamento departamento) {
        this(0, idTecnico, idSupervisor,idMaquina, statusOS, descricao, valorOS, departamento);
    }

    //------------- GETTERS  -------------//
    public long getIdOs() {
        return idOS;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    public long getIdTecnico() {
        return idTecnico;
    }

    public long getIdSupervisor() {
        return idSupervisor;
    }

    public ValorOS getValorOS() {
        return valorOS;
    }

    public StatusOS getStatusOS() {
        return statusOS;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    //------------- ALTERADORES  -------------//
    public void alteraDescricao(Descricao descricao) {
        if(descricao == null) {
            throw new DescricaoOsException("Uma ordem de servico deve possuir sua descrição bem definida");
        }

        this.descricao = descricao;
    }

    public void alteraValorOS(ValorOS valorOS) {
        if(valorOS == null) {
            throw new ValorOsException("Uma ordem de servico deve possuir seu valor bem definido");
        }

       this.valorOS = valorOS;
    }

    public void alteraIdOS(long idOS) {
        if(this.idOS != 0) {
            throw new IdOsException("Não é possível alterar o ID de uma ordem de serviço");
        }

        if(idOS < 0) {
            throw new IdOsException("O ID da ordem de serviço informado está inválido");
        }

        this.idOS = idOS;
    }

    public void alteraIdMaquina(long idMaquina) {
        if(idMaquina < 1) {
            throw new IdMaquinaOsException("O ID da máquina não pode ser menor que 1");
        }

        this.idMaquina = idMaquina;
    }

    public void alteraIdTecnico(long idTecnico) {
        if(idTecnico < 1) {
            throw new IdTecnicoOsException("O ID do técnico não pode ser menor que 1");
        }

        this.idTecnico = idTecnico;
    }

    public void alteraIdSupervisor(long idSupervisor) {
        if(idSupervisor < 1) {
            throw new IdSupervisorOsException("O ID do supervisor não pode ser menor que 1");
        }

        this.idSupervisor = idSupervisor;
    }

    public void alteraStatusOS(StatusOS statusOS) {
        if(statusOS == null) {
            throw new StatusOsException("Uma ordem de serviço deve possuir seu status bem definido");
        }

        this.statusOS = statusOS;
    }

    public void alteraDepartamento(Departamento departamento) {
        if(departamento == null) {
            throw new DepartamentoOsException("Uma ordem de serviço deve possuir seu departamento bem definido");
        }

        this.departamento = departamento;
    }
}
