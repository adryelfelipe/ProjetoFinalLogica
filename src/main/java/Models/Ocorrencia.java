package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.StatusOc;
import Service.Validator.OcorrenciaValidator;

public class Ocorrencia {

    // Atributos
    private long ID_OC;
    private Departamento departamento;
    private long idMaquina;
    private StatusOc statusOC;

    // Construtor com ID
    public Ocorrencia(long ID_OC, Departamento departamento, long idMaquina, StatusOc statusOC)
    {
        this.ID_OC = ID_OC;
        this.departamento = departamento;
        this.idMaquina = idMaquina;
        this.statusOC = statusOC;
    }

    // Construtor sem ID
    public Ocorrencia(Departamento departamento, long idMaquina, StatusOc statusOC)
    {
        this.departamento = departamento;
        this.idMaquina = idMaquina;
        this.statusOC = statusOC;
    }

    // getters e setters
    public long getID_OC()
    {
        return ID_OC;
    }

    public Departamento getDepartamento()
    {
        return departamento;
    }

    public long getIdMaquina()
    {
        return idMaquina;
    }

    public StatusOc getStatusOC()
    {
        return statusOC;
    }

    public void setID_OC(long ID_OC)
    {
        OcorrenciaValidator.verificarIdOc(ID_OC);
        this.ID_OC = ID_OC;
    }

    public void setDepartamento(Departamento departamento)
    {
        OcorrenciaValidator.verificarDepartamento(departamento);
        this.departamento = departamento;
    }

    public void setIdMaquina(long idMaquina)
    {
        OcorrenciaValidator.verificarIdMaquina(idMaquina);
        this.idMaquina = idMaquina;
    }

    public void setStatusOC(StatusOc statusOC)
    {
        OcorrenciaValidator.verificarStatusOc(statusOC);
        this.statusOC = statusOC;
    }
}
