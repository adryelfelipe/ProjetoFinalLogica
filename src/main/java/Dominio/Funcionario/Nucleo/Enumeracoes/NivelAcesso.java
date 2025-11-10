package Dominio.Funcionario.Nucleo.Enumeracoes;

public class NivelAcesso {
    // ID 1
    public static NivelAcesso TECNICO = new NivelAcesso("Técnico ", 1);
    // ID 2
    public static NivelAcesso SUPERVISOR = new NivelAcesso("Supervisor", 2);
    // ID 3
    public static NivelAcesso GERENTE = new NivelAcesso("Em Gerente", 3);
    // ID 4
    public static NivelAcesso ADMIN = new NivelAcesso("Em Admin", 4);

    // -- Atributos -- //
    private final String nome;
    private final int id;

    // -- Construtor privado -- //
    private NivelAcesso(String nome, int id) {
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
