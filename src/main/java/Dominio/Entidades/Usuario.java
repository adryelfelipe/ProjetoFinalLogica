package Dominio.Entidades;

import Dominio.Enumeracoes.NivelAcesso;
import ProjetoBase.UsuarioValidator;

public abstract class Usuario {

    // -- Atributos -- //
    private String nome;
    private String cpf;
    private String senha;
    private NivelAcesso nivelAcesso;
    private long idUsuario;

    // -- Construtor com ID -- //
    public Usuario(long id, String nome, String cpf, String senha, NivelAcesso nivelAcesso) {
        setIdUsuario(id);
        setNome(nome);
        setNivelAcesso(nivelAcesso);
        setCpf(cpf);
        setSenha(senha);
    }

    // -- Construtor sem ID-- //
    public Usuario(String nome, String cpf, String senha, NivelAcesso nivelAcesso)
    {
        this(0, nome, cpf, senha, nivelAcesso);
    }

    // -- Setters e Getters -- //

    public long getIdUsuario() {
        return idUsuario;
    }

    public NivelAcesso getNivelAcesso() {
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

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        UsuarioValidator.verificaIntegridadeNivelAcesso(nivelAcesso);
        this.nivelAcesso = nivelAcesso;
    }
}