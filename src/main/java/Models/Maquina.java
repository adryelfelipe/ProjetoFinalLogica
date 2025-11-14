package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.StatusMaquina;

public class Maquina {

    // -- Atributos -- //
    private long idMaquina;
    private String nome;
    private Departamento departamento;
    private StatusMaquina status;


    // Construtor com ID //
    public Maquina(long id, String nome, Departamento localizacao, StatusMaquina idStatus) {
        setNome(nome);
        setIdMaquina(id);
        setDepartamento(departamento);
        setStatus(idStatus);
    }

    // Construtor sem ID //
    public Maquina(String nome, Departamento departamento, StatusMaquina idStatus) {
        this(0, nome, departamento, idStatus);
    }

    // -- Setters e Getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public StatusMaquina getStatus() {
        return status;
    }

    public void setStatus(StatusMaquina status) {
        this.status = status;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(long idMaquina) {
        this.idMaquina = idMaquina;
    }
}