package Dominio.Funcionario.Nucleo.Enumeracoes;

public enum Departamento {

    // -- Atributos enumerados -- //
    // ID 1
    ELETRICA(1),
    // ID 2
    MECANICA(2);

    // -- Atributos -- //
    private final int id;

    // -- Construtor privado -- //
    Departamento(int id) {
        this.id = id;
    }

    // -- Getters -- //
    public int getId() {
        return id;
    }
}
