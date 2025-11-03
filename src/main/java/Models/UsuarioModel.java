package Models;

import ProjetoBase.UsuarioValidator;

public abstract class UsuarioModel {

    // -- Atributos -- //
    private String nome;
    private String cpf;
    private String senha;
    private int nivelAcesso;
    private long idUsuario;

    // -- Construtor com ID -- //
    public UsuarioModel(long id, String nome, String cpf, String senha, int nivelAcesso) {
        setIdUsuario(id);
        setNome(nome);
        setNivelAcesso(nivelAcesso);
        setCpf(cpf);
        setSenha(senha);
    }

    // -- Construtor sem ID-- //
    public UsuarioModel(String nome, String cpf, String senha, int nivelAcesso)
    {
        this(0, nome, cpf, senha, nivelAcesso);
    }

    // -- Setters e Getters -- //

    public long getIdUsuario() {
        return idUsuario;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setIdUsuario(long id) {
        UsuarioValidator.verificaIntegridadeIdUsuario(id);
        this.idUsuario = id;
    }

    public void setSenha(String senha) {
        UsuarioValidator.verificaIntegridadeSenha(senha);
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        UsuarioValidator.verificaIntegridadeCpf(cpf);
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        UsuarioValidator.verificaIntegridadeNome(nome);
        this.nome = nome;
    }

    public void setNivelAcesso(int nivelAcesso) {
        UsuarioValidator.verificaIntegridadeNivelAcesso(nivelAcesso);
        this.nivelAcesso = nivelAcesso;
    }
}