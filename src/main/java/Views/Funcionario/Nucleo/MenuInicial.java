package Views.Funcionario.Nucleo;

import Util.Ferramentas;
import Views.Sistema.MenuDesligar;

import java.util.InputMismatchException;

public class MenuInicial
{
    // -- Métodos -- //
    public static void Menu()
    {
        int opcao;

        while(true) {
            System.out.println(Ferramentas.BLUE+"▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉");
            System.out.println("▉▉▉  ");
            System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
            System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
            System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉   ▉▉▉");
            System.out.println("▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
            System.out.println("▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
            System.out.println("                                  ▉▉▉");
            System.out.println("▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉"+Ferramentas.RESET);

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃             WEG OS             ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃  1 - Login                     ┃");
            System.out.println("┃  2 - Sair                      ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                opcao = Ferramentas.lInteiro();

                switch(opcao) {
                    case 1 -> {
                        Ferramentas.limpaTerminal();
                        MenuLogin.login();
                    }
                    case 2 -> {
                        Ferramentas.limpaTerminal();
                        MenuDesligar.desligar();
                    }
                    default -> Ferramentas.menuDefault();
                }
            }
            catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}