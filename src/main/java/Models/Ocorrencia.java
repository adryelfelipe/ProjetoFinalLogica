package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.StatusOc;

public class Ocorrencia {

    // Atributos
    private long ID_OC;
    private Departamento departamento;
    private long idMaquina;
    private StatusOc statusOC;

    // Construtor sem ID
    public Ocorrencia(long ID_OC, Departamento departamento, long idMaquina, StatusOc statusOC)
    {

    }
}
