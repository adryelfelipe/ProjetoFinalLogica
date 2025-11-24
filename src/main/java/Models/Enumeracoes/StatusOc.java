package Models.Enumeracoes;

public class StatusOc {
    // ID 1
    public static StatusOc ABERTA = new StatusOc("Aberta ", 1);
    // ID 2
    public static StatusOc EM_ANDAMENTO = new StatusOc("Em andamento", 2);
    // ID 3
    public static StatusOc FECHADA = new StatusOc("Fechada", 3);

    // -- Atributos -- //
    private final String nome;
    private final int id;

    // -- Construtor privado -- //
    private StatusOc(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    // -- Getters -- //
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
