package Views.Sistema;

import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuEscolhaId
{
    public static long escolhaIdUpdate() {
        while(true) {
            System.out.print("┃ ➤ Digite o ID: ");

            try {
                return Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static long escolhaIdOs() {
        while(true) {
            System.out.print("┃ ➤ Digite o ID: ");

            try {
                long id = Ferramentas.lInteiro();
                return id;
            } catch (InputMismatchException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
