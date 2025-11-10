package Dominio.Compartilhado;

import Dominio.Funcionario.Nucleo.Exceptions.NomeFuncionarioException;

public abstract class Nome {
    private final String nome;

    public Nome(String nome) {
        validaNome(nome);
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    private void validaNome(String nome) {
        if(nome.isBlank()) {
            throw new NomeFuncionarioException("Um nome não pode ser vazio");
        }

        if(nome.length() < 2) {
            throw new NomeFuncionarioException("Um nome deve possuir mais de um caractere");
        }
    }
}
