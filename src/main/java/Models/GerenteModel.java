package Models;

import ProjetoBase.GerenteValidator;

public class GerenteModel extends UsuarioModel{

    // -- Atributos -- //
    private int departamento;

    // -- Construtor com ID -- //
    public GerenteModel(long id, String nome, String cpf, String senha, int departamento) {
        super(id, nome, cpf, senha, 3);
        setDepartamento(departamento);
    }

    // -- Construtor sem ID -- //
    public GerenteModel(String nome, String cpf, String senha, int departamento) {
        this(0, nome, cpf, senha, departamento);
    }

    // -- Setters e Getters -- //
    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        GerenteValidator.verificaIntegridadeIdDepartamento(departamento);
        this.departamento = departamento;
    }
}
