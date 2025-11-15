package Dominio.Ocorrencia.Enumeracoes;

public enum StatusOc {
    // -- Enumeracoes -- //
    ABERTA (1),
    EM_ANDAMENTO (2),
    FECHADA (3);

    // -- Atributos -- //
    long id;

    // -- Construtor -- //
    StatusOc(long id) {
        this.id = id;
    }
}
