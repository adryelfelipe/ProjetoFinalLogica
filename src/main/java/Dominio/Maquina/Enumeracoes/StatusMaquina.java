package Dominio.Maquina.Enumeracoes;

public enum StatusMaquina {
    // ID 1
    FUNCIONANDO(1),
    // ID 2
    DEFEITO(2),
    // ID 3
    EM_MANUTENCAO(3);

    // -- Atributos -- //
    private final int id;

    // -- Construtor privado -- //
    private StatusMaquina(int id) {
        this.id = id;
    }

    // -- Getters -- //
    public int getId() {
        return id;
    }
}
