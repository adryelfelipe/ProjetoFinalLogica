package ProjetoBase;

public class MaquinaModel {

    // -- Atributos -- //
    private long idMaquina;
    private String nome;
    private String localizacao;
    private int status;


    // Construtor com ID //
    public MaquinaModel(long id, String nome, String localizacao, int status) {
        setNome(nome);
        setIdMaquina(id);
        setLocalizacao(localizacao);
        setStatus(status);
    }

    // Construtor sem ID //
    public MaquinaModel(String nome, String localizacao, String status) {
        //this(0, nome, localizacao, status);
    }

    // -- Setters e Getters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(long idMaquina) {
        this.idMaquina = idMaquina;
    }
}