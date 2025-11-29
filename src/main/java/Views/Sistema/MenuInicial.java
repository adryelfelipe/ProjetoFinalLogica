package Views.Sistema;

import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuInicial
{
    // -- Métodos -- //
    public static void Menu()
    {
        int opcao;

        while(true) {
            System.out.println(Ferramentas.OCEAN_BLUE+"          ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉");
            System.out.println("          ▉▉▉  ");
            System.out.println("          ▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
            System.out.println("          ▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
            System.out.println("          ▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉   ▉▉▉");
            System.out.println("          ▉▉▉   ▉▉▉   ▉▉▉   ▉▉▉       ▉▉▉   ▉▉▉");
            System.out.println("          ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉   ▉▉▉▉▉▉▉▉▉");
            System.out.println("                                            ▉▉▉");
            System.out.println("          ▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉▉"+Ferramentas.AQUA_BLUE);


            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                         "+Ferramentas.ORANGE_DARK+"WEG OS"+Ferramentas.AQUA_BLUE+"                         ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Login"+Ferramentas.AQUA_BLUE+"                                             ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Sair"+Ferramentas.AQUA_BLUE+"                                              ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

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