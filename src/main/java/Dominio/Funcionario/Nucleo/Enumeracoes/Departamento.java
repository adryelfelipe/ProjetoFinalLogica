package Dominio.Funcionario.Nucleo.Enumeracoes;

public class Departamento {

    // -- Atributos enumerados -- //
    // ID 1
    public static Departamento ELETRICA = new Departamento("Elétrica ", 1);
    // ID 2
    public static Departamento MECANICA = new Departamento("Mecânica", 2);

    // -- Atributos -- //
    private final String nome;
    private final int id;

    // -- Construtor privado -- //
    private Departamento(String nome, int id) {
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
