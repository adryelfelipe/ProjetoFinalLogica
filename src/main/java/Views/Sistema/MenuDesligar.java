package Views.Sistema;

import Util.Ferramentas;

public class MenuDesligar
{
    public static void desligar()
    {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                    "+Ferramentas.ORANGE_DARK+"DESLIGANDO . . ."+Ferramentas.AQUA_BLUE+"                    ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        Ferramentas.Delay(1500);

        System.exit(0);
    }
}
