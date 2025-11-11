package Dominio.OrdemDeServico.Enumeracoes;

public class TipoOS {
    // ID 1
    public static TipoOS CORRETIVA = new TipoOS("Corretiva ", 1);
    // ID 2
    public static TipoOS PREDITIVA = new TipoOS("", 2);

    // -- Atributos -- //
    private final String nome;
    private final int id;

    // -- Construtor privado -- //
    private TipoOS(String nome, int id) {
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
