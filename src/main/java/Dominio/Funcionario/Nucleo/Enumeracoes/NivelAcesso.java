package Dominio.Funcionario.Nucleo.Enumeracoes;

public enum NivelAcesso {
    // ID 1
    TECNICO(1),
    // ID 2
    SUPERVISOR(2),
    // ID 3
    GERENTE(3),
    // ID 4
    ADMIN(4);

    // -- Atributos -- //
    private final int id;

    // -- Construtor privado -- //
    NivelAcesso(int id) {
        this.id = id;
    }

    // -- Getters -- //
    public int getId() {
        return id;
    }
}
