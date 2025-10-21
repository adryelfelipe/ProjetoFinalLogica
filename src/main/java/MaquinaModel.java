public class MaquinaModel {

    // -- Atributos -- //
    private long idMaquina;
    private String nome;
    private String localizacao;
    private String status;


    // Construtor com ID //
    public MaquinaModel(long id, String nome, String localizacao, String status) {
        setNome(nome);
        setIdMaquina(id);
        setLocalizacao(localizacao);
        setStatus(status);
    }

    // Construtor sem ID //
    public MaquinaModel(String nome, String localizacao, String status) {
        this(0, nome, localizacao, status);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(long idMaquina) {
        this.idMaquina = idMaquina;
    }
}