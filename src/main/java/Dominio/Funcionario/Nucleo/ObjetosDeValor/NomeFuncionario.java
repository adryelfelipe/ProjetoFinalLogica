package Dominio.Funcionario.Nucleo.ObjetosDeValor;

import Dominio.Compartilhado.Nome;
import Dominio.Funcionario.Nucleo.Exceptions.NomeFuncionarioException;
import Util.FerramentaValidator;
import Util.Ferramentas;

public final class NomeFuncionario extends Nome {
    public NomeFuncionario(String nome) {
        super(nome);
        validaNomeFuncionario(this.getNome());
    }

    private void validaNomeFuncionario(String nome) {
        // -- VALIDAÇÃO DE CARACTERES ESPECIAIS -- //
        boolean caractereEspcial = FerramentaValidator.isContemCaractereEspecial(nome);
        boolean numero = FerramentaValidator.isContemNumero(nome);

        if(caractereEspcial || numero) {
            throw new NomeFuncionarioException("Um nome de funcionário pode possuir apenas letras");
        }
    }
}
