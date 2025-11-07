package Models;

import Models.joias.Departamento;
import Models.joias.NivelAcesso;
import ProjetoBase.UsuarioValidator;

public abstract class UsuarioModel {

    // -- Atributos -- //
    private String nome;
    private String cpf;
    private String senha;
    private NivelAcesso nivelAcesso;
    private long idUsuario;
    private Departamento departamento;

    // -- Construtor com ID -- //
    public UsuarioModel(long id, String nome, String cpf, String senha, Departamento departamento, NivelAcesso nivelAcesso) {
        setIdUsuario(id);
        setNome(nome);
        setNivelAcesso(nivelAcesso);
        setCpf(cpf);
        setSenha(senha);
        setDepartamento(departamento);
    }

    // -- Construtor sem ID-- //
    public UsuarioModel(String nome, String cpf, String senha, Departamento departamento, NivelAcesso nivelAcesso)
    {
        this(0, nome, cpf, senha, departamento, nivelAcesso);
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

    public Departamento getDepartamento() {
        return departamento;
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

    public void setDepartamento(Departamento departamento)
    {
        this.departamento = departamento;
    }
}