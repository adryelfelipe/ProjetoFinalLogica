package Dominio.Maquina.ObjetosDeValor;

import Dominio.Maquina.Exceptions.NomeMaquinaException;

public final class NomeMaquina {
    private final String nome;

    public NomeMaquina(String nome) {
        validaNome(nome);
        this.nome = nome;
    }

    private void validaNome(String nome) {
        if(nome.isBlank()) {
            throw new NomeMaquinaException("Um nome não pode ser vazio");
        }

        if(nome.length() < 2) {
            throw new NomeMaquinaException("Um nome deve possuir mais de um caractere");
        }
    }

    public String getNome() {
        return nome;
    }
}
