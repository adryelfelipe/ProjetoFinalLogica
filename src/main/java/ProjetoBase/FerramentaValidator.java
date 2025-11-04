package ProjetoBase;

import Util.Ferramentas;

public class FerramentaValidator {
    public static boolean isContemMaiuscula(String palavra) {
        for(String maiuscula : Ferramentas.listaMaiusculos) {
            if (palavra.contains(maiuscula)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isContemMinuscula(String palavra) {
        for(String minuscula : Ferramentas.listaMinusculas) {
            if (palavra.contains(minuscula)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isContemCaractereEspecial(String palavra) {
        for(String caractereEspecial : Ferramentas.listaEspeciais) {
            if (palavra.contains(caractereEspecial)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isContemNumero(String palavra) {
        for(String numero : Ferramentas.listaNumeros) {
            if (palavra.contains(numero)) {
                return true;
            }
        }

        return false;
    }
}
