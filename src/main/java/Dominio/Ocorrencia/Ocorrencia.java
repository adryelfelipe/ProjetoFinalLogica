package Dominio.Ocorrencia;

import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Dominio.Ocorrencia.Exceptions.DepartamentoOcException;
import Dominio.Ocorrencia.Exceptions.IdMaquinaOcException;
import Dominio.Ocorrencia.Exceptions.IdOcorrenciaException;
import Dominio.Ocorrencia.Exceptions.StatusOcException;

public class Ocorrencia {
    long idOcorrencia;
    long idMaquina;
    Departamento departamento;
    StatusOc statusOc;

    // Construtor com ID
    public Ocorrencia(long idOcorrencia, long idMaquina, Departamento departamento, StatusOc statusOc) {
        alteraIdOcorrencia(idOcorrencia);
        alteraIdMaquina(idMaquina);
        alteraDepartamento(departamento);
        alteraStatusOc(statusOc);
    }

    // Construtor sem ID
    public Ocorrencia(long idMaquina, Departamento departamento, StatusOc statusOc) {
        this(0, idMaquina, departamento, statusOc);
    }

    // -- Getters -- //
    public long getIdOcorrencia() {
        return idOcorrencia;
    }

    public StatusOc getStatusOc() {
        return statusOc;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    // -- Alteradores -- //
    public void alteraIdOcorrencia(long idOcorrencia) {
        if(idOcorrencia < 0) {
            throw new IdOcorrenciaException("O id da ocorrência não pode ser menor que 0");
        }

        this.idOcorrencia = idOcorrencia;
    }

    public void alteraStatusOc(StatusOc statusOc) {
        if(statusOc == null) {
            throw new StatusOcException("O status da ocorrência deve ser bem definido");
        }

        this.statusOc = statusOc;
    }

    public void alteraDepartamento(Departamento departamento) {
        if(departamento == null) {
            throw new DepartamentoOcException("O departamento da ocorrência deve ser bem definido");
        }

        this.departamento = departamento;
    }

    public void alteraIdMaquina(long idMaquina) {
        if(idMaquina < 0) {
            throw new IdMaquinaOcException("O id da máquina da ocorrência não pode ser menor que 0");
        }

        this.idMaquina = idMaquina;
    }
}
