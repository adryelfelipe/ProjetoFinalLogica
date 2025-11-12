package Dominio.Funcionario.Nucleo.ObjetosDeValor;

import Dominio.Funcionario.Nucleo.Exceptions.NomeFuncionarioException;
import Dominio.Maquina.Exceptions.NomeMaquinaException;
import Util.FerramentaValidator;

public final class NomeFuncionario {
    private final String nome;

    public NomeFuncionario(String nome) {
        validaNomeFuncionario(nome);
        this.nome = nome;
    }

    private void validaNomeFuncionario(String nome) {
        if(nome.isBlank()) {
            throw new NomeFuncionarioException("Um nome não pode ser vazio");
        }

        if(nome.length() < 2) {
            throw new NomeFuncionarioException("Um nome deve possuir mais de um caractere");
        }

        // -- VALIDAÇÃO DE CARACTERES ESPECIAIS -- //
        boolean caractereEspcial = FerramentaValidator.isContemCaractereEspecial(nome);
        boolean numero = FerramentaValidator.isContemNumero(nome);

        if(caractereEspcial || numero) {
            throw new NomeFuncionarioException("Um nome de funcionário pode possuir apenas letras");
        }
    }

    public String getNome() {
        return nome;
    }
}
