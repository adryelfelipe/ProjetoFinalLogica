package Models.Enumeracoes;

public class StatusOC {
    //ID 1
    public static StatusOC ABERTA = new StatusOC("Aberta", 1);
    //ID 2
    public static StatusOC EM_ANDAMENTO = new StatusOC("Em andamento", 2);
    //ID 3
    public static StatusOC FECHADA = new StatusOC("Fechada", 3);

    // Atributos
    private final String nome;
    private final int id;

    // Construtor privado
    private StatusOC(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    // Getter
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
