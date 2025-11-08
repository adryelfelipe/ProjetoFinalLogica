package Dominio.Entidades;

import Dominio.Enumeracoes.Departamento;
import Dominio.Enumeracoes.NivelAcesso;
import ProjetoBase.GerenteValidator;

public class Gerente extends Usuario {

    // -- Atributos -- //
    private Departamento departamento;

    // -- Construtor com ID -- //
    public Gerente(long id, String nome, String cpf, String senha, Departamento departamento) {
        super(id, nome, cpf, senha, NivelAcesso.GERENTE);
        setDepartamento(departamento);
    }

    // -- Construtor sem ID -- //
    public Gerente(String nome, String cpf, String senha, Departamento departamento) {
        this(0, nome, cpf, senha, departamento);
    }

    // -- Setters e Getters -- //
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        GerenteValidator.verificaIntegridadeDepartamento(departamento);
        this.departamento = departamento;
    }
}
