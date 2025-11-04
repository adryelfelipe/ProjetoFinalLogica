package Views;

import Util.Ferramentas;

public class MenuDesligar
{
    public static void desligar()
    {
        System.out.println("|  ----------------------------  |");
        System.out.println("|        Desligando . . .        |");
        System.out.println("|  ----------------------------  |");

        Ferramentas.Delay(1500);

        System.exit(0);
    }
}
