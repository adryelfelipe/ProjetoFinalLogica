package Dominio.OrdemDeServico.Enumeracoes;

public enum StatusOS {
    // ID 1
    ABERTA( 1),
    // ID 2
    EM_ANDAMENTO( 2),
    // ID 3
    FECHADA( 3);

    // -- Atributos -- //
    private final int id;

    // -- Construtor privado -- //
    StatusOS( int id) {
        this.id = id;
    }

    // -- Getters -- //
    public int getId() {
        return id;
    }
}
