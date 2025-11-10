package Dominio.Funcionario.Nucleo;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Exceptions.*;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.CPF;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.NomeFuncionario;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.Senha;

public abstract class Funcionario {

    // -- Atributos -- //
    private NomeFuncionario nomeFuncionario;
    private CPF cpf;
    private Senha senha;
    private NivelAcesso nivelAcesso;
    private Long idFuncionario;
    private ListaDepartamentos listaDepartamentos;

    // -- Construtor com ID -- //
    public Funcionario(Long id, NomeFuncionario nome, CPF cpf, Senha senha, NivelAcesso nivelAcesso, ListaDepartamentos listaDepartamentos) {
        alteraListaDepartamentos(listaDepartamentos);
        alteraIdUsuario(id);
        alteraNome(nome);
        alteraNivelAcesso(nivelAcesso);
        alteraCpf(cpf);
        alteraSenha(senha);
    }

    // -- Construtor sem ID -- //
    public Funcionario(NomeFuncionario nome, CPF cpf, Senha senha, NivelAcesso nivelAcesso, ListaDepartamentos listaDepartamentos)
    {
        this(null, nome, cpf, senha, nivelAcesso, listaDepartamentos);
    }

    // -- Getters -- //
    public Long getIdUsuario() {
        return idFuncionario;
    }

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public Senha getSenha() {
        return senha;
    }

    public CPF getCpf() {
        return cpf;
    }

    public NomeFuncionario getNome() {
        return nomeFuncionario;
    }

    public ListaDepartamentos getDepartamentos() {
        return listaDepartamentos;
    }

    // -- Alteradores -- //
    public void alteraListaDepartamentos(ListaDepartamentos listaDepartamentos) {
        if(listaDepartamentos == null) {
            throw new DepartamentoFuncionarioException("A lista de departamentos de um funcionário não pode ser vazia");
        }

        this.listaDepartamentos = listaDepartamentos;
    }

    public void alteraIdUsuario(Long id) {
        if(this.idFuncionario != null) {
            throw new IdFuncionarioException("Não é possível alterar o ID de um funcionário");
        }

        if(id != null && id < 1) {
            throw new IdFuncionarioException("O ID do funcionário informado está inválido");
        }

        this.idFuncionario = id;
    }

    public void alteraSenha(Senha senha) {
        if(senha == null) {
            throw new SenhaInvalidaException("Um funcionário deve possuir sua senha bem definida");
        }

        this.senha = senha;
    }

    public void alteraCpf(CPF cpf) {
        if(cpf == null) {
            throw new CpfInvalidoException("Um funcionário deve possuir seu cpf bem definido");
        }

        this.cpf = cpf;
    }

    public void alteraNome(NomeFuncionario nomeFuncionario) {
        if(nomeFuncionario == null) {
            throw new NomeFuncionarioException("Um funcionário deve possuir seu nome bem definido");
        }

        this.nomeFuncionario = nomeFuncionario;
    }

    public void alteraNivelAcesso(NivelAcesso nivelAcesso) {
        if(nivelAcesso == null) {
            throw new NivelAcessoException("Um funcionário deve possuir seu nível de acesso bem definido");
        }

        if(nivelAcesso.getId() > 4) {
            throw new NivelAcessoException("Um funcionário não pode ter seu nivel de acesso maior que 4");
        }

        if(nivelAcesso.getId() < 1) {
            throw new NivelAcessoException("Um funcionário não pode ter seu nível de acesso menor que 1");
        }

        this.nivelAcesso = nivelAcesso;
    }

    // -- Métodos -- //
    public void adicionarDepartamento(Departamento departamento) {
        if(departamento == null) {
            throw new DepartamentoFuncionarioException("Um funcionário só pode possuir departamentos válidos");
        }

        listaDepartamentos.getListaDepartamentos().add(departamento);
    }

    public void removerDepartamento(Departamento departamento) {
        this.listaDepartamentos.getListaDepartamentos().remove(departamento);
    }

    public boolean igualMeuId(Long idComparado) {
        return idFuncionario != null && idFuncionario.equals(idComparado);
    }


    public boolean igualMinhaSenha(String senha) {
        return this.getSenha().getSenha().equals(senha);
    }
}