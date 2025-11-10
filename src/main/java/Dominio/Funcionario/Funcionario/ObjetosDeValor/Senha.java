package Dominio.Funcionario.Funcionario.ObjetosDeValor;

import Dominio.Funcionario.Funcionario.Exceptions.SenhaInvalidaException;
import ProjetoBase.FerramentaValidator;

public final class Senha {
    private final String senha;

    public Senha(String senha) {
        validaSenha(senha);
        this.senha = senha;
    }

    private void validaSenha(String senha) {
        if(senha.isBlank()) {
            throw new SenhaInvalidaException("A senha não pode ser vazia");
        }

        if(senha.contains(" ")) {
            throw new SenhaInvalidaException("A senha não pode conter espaços");
        }

        if(senha.length() < 6) {
            throw new SenhaInvalidaException("A senha deve conter no mínimo 6 caracteres");
        }


        // -- VALIDAÇÃO DE MAIUSCULAS E ESPECIAIS -- //
        boolean verificaMaiuscula = FerramentaValidator.isContemMaiuscula(senha);
        boolean verificaEspecial = FerramentaValidator.isContemCaractereEspecial(senha);
        boolean verificaNumeros = FerramentaValidator.isContemNumero(senha);

        if(!verificaMaiuscula) {
            throw new SenhaInvalidaException("A senha deve conter uma letra maiúscula");
        }

        if(!verificaEspecial) {
            throw new SenhaInvalidaException("A senha deve conter um caractere especial");
        }

        if(!verificaNumeros) {
            throw new SenhaInvalidaException("A senha deve conter um número");
        }
    }

    public String getSenha() {
        return this.senha;
    }
}
