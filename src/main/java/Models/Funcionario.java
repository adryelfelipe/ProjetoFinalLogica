package Models;

import Models.Enumeracoes.Departamento;
import Models.Enumeracoes.NivelAcesso;
import Service.Validator.UsuarioValidator;

import java.util.List;

public abstract class Funcionario {

    // -- Atributos -- //
    private String nome;
    private String cpf;
    private String senha;
    private NivelAcesso nivelAcesso;
    private long idUsuario;
    private List<Departamento> listaDepartamentos;

    public Funcionario() {

    }

    public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    // -- Construtor com ID -- //
    public Funcionario(long id, String nome, String cpf, String senha, NivelAcesso nivelAcesso, List<Departamento> listaDepartamentos) {
        setIdUsuario(id);
        setNome(nome);
        setNivelAcesso(nivelAcesso);
        setCpf(cpf);
        setSenha(senha);
        this.listaDepartamentos = listaDepartamentos;
    }

    // -- Construtor sem ID-- //
    public Funcionario(String nome, String cpf, String senha, NivelAcesso nivelAcesso, List<Departamento> listaDepartamentos) {
        this(0, nome, cpf, senha, nivelAcesso, listaDepartamentos);
    }

    // -- Setters e Getters -- //

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

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