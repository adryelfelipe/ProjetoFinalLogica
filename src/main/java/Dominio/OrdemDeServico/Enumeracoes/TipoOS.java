package Dominio.OrdemDeServico.Enumeracoes;

public enum TipoOS {
    // ID 1
    CORRETIVA(1),
    // ID 2
    PREDITIVA(2);
    // -- Atributos -- //
    private final int id;

    // -- Construtor privado -- //
    TipoOS(int id) {
        this.id = id;
    }

    // -- Getters -- //
    public int getId() {
        return id;
    }
}
