package Dominio.Funcionario.Funcionario.ObjetosDeValor;

import Dominio.Compartilhado.Nome;
import Dominio.Funcionario.Funcionario.Exceptions.NomeFuncionarioException;
import ProjetoBase.FerramentaValidator;

public final class NomeFuncionario extends Nome {
    public NomeFuncionario(String nome) {
        super(nome);
        validaNomeFuncionario(this.getNome());
    }

    private void validaNomeFuncionario(String nome) {
        // -- VALIDAÇÃO DE CARACTERES ESPECIAIS -- //
        boolean caractereEspcial = FerramentaValidator.isContemCaractereEspecial(nome);

        if(caractereEspcial) {
            throw new NomeFuncionarioException("Um nome de funcionário não pode possuir caractere especial");
        }
    }
}
