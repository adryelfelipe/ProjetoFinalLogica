package Dominio.Enumeracoes;

public class StatusOS {
    // ID 1
    public static StatusOS EM_ANDAMENTO = new StatusOS("Em Andamento ", 1);
    // ID 2
    public static StatusOS ATRASADA = new StatusOS("Atrasada", 2);
    // ID 3
    public static StatusOS FECHADA = new StatusOS("Fechada", 3);

    // -- Atributos -- //
    private final String nome;
    private final int id;

    // -- Construtor privado -- //
    private StatusOS(String nome, int id) {
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
