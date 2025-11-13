package Dominio.Funcionario.Tecnico.Enumeracoes;

public enum Especialidade {
    // -- Atributos enumerados -- //
    // ID 1
    TECNICO_ELETROTECNICA(1),
    // ID 2
    ELETRICISTA_FABRIL(2),
    // ID 3
    SOLDADOR(3),
    // ID 4
    TECNICO_ELETROMECANICA(4),
    // ID 5
    PINTOR_INDUSTRIAL(5);

    // -- Atributos -- //
    private final int id;

    // -- Construtor privado -- //
    Especialidade(int id) {
        this.id = id;
    }

    // -- Getters -- //
    public int getId() {
        return id;
    }
}