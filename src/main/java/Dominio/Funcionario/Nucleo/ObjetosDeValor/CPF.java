package Dominio.Funcionario.Nucleo.ObjetosDeValor;

import Dominio.Funcionario.Nucleo.Exceptions.CpfInvalidoException;
import ProjetoBase.FerramentaValidator;

public final class CPF {
    private final String cpf;

    public CPF(String cpf) {
        validaCpf(cpf);
        this.cpf = cpf;
    }

    private void validaCpf(String cpf) {
        if(cpf.isBlank()) {
            throw new CpfInvalidoException("Um CPF não pode ser vazio");
        }

        if(cpf.length() != 11) {
            throw  new CpfInvalidoException("Um CPF deve possuir 11 dígitos");
        }

        if(cpf.contains(" ")) {
            throw new CpfInvalidoException("Um CPF não pode conter espaços");
        }

        // -- VALIDAÇÃO DE MAIUSCULAS E ESPECIAIS -- //
        boolean verificaMaiuscula = FerramentaValidator.isContemMaiuscula(cpf);
        boolean verificaMinuscula = FerramentaValidator.isContemMinuscula(cpf);
        boolean verificaCaractereEspecial = FerramentaValidator.isContemCaractereEspecial(cpf);

        if(verificaMaiuscula || verificaMinuscula || verificaCaractereEspecial) {
            throw new CpfInvalidoException("Um CPF deve conter somente dígitos");
        }
    }

    public String getCpf() {
        return this.cpf;
    }
}
