package Dominio.Enumeracoes;

public class StatusMaquina {
    // ID 1
    public static StatusMaquina FUNCIONANDO = new StatusMaquina("Funcionando ", 1);
    // ID 2
    public static StatusMaquina DEFEITO = new StatusMaquina("Defeito", 2);
    // ID 3
    public static StatusMaquina EM_MANUTENCAO = new StatusMaquina("Em Manutenção", 3);

    // -- Atributos -- //
    private final String nome;
    private final int id;

    // -- Construtor privado -- //
    private StatusMaquina(String nome, int id) {
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
