package Menus;

public class MenuDesligar
{
    public static void desligar()
    {
        System.out.println("-------------------------");
        System.out.println("     Desligando . . .    ");
        System.out.println("-------------------------");

        ProjetoBase.Ferramentas.Delay(1500);

        System.exit(0);
    }
}
