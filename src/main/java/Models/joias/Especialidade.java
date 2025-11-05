package Models.joias;

public class Especialidade {
    // -- Atributos enumerados -- //
    // ID 1
    public static Especialidade TECNICO_ELETROTECNICA = new Especialidade("Técnico em Eletrotécnica", 1);
    // ID 2
    public static Especialidade ELETRICISTA_FABRIL = new Especialidade("Eletrecista Fábril", 2);
    // ID 3
    public static Especialidade SOLDADOR = new Especialidade("Soldador", 3);
    // ID 4
    public static Especialidade TECNICO_ELETROMECANICA = new Especialidade("Técnico em Eletromecânica", 4);
    // ID 5
    public static Especialidade PINTOR_INDUSTRIAL = new Especialidade("Pintor Industrial", 5);

    // -- Atributos -- //
    private final String nome;
    private final int id;

    // -- Construtor privado -- //
    private Especialidade(String nome, int id) {
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