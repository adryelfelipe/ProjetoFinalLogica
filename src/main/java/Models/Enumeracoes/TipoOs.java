package Models.Enumeracoes;

public enum TipoOs {
    // ID 1
    CORRETIVA(1),
    // ID 2
    PREDITIVA(2);
    // -- Atributos -- //
    private final int id;

    // --TipoOS Construtor -- //
    TipoOs(int id) {
        this.id = id;
    }

    // -- Getters -- //
    public int getId() {
        return id;
    }
}
