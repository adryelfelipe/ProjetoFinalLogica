package Models;

import Models.joias.Departamento;
import ProjetoBase.GerenteValidator;

public class GerenteModel extends UsuarioModel{

    // -- Atributos -- //
    private Departamento departamento;

    // -- Construtor com ID -- //
    public GerenteModel(long id, String nome, String cpf, String senha, Departamento departamento) {
        super(id, nome, cpf, senha, 3);
        setDepartamento(departamento);
    }

    // -- Construtor sem ID -- //
    public GerenteModel(String nome, String cpf, String senha, Departamento departamento) {
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
