package Views.Gerente;

import Util.Ferramentas;

public class MenuGerenteRelatorios
{
    public static void visualizarRelatorios()
    {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃     VISUALIZAR RELATÓRIOS      ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        try
        {

        }
        catch(IllegalArgumentException | IllegalStateException e)
        {
            Ferramentas.menuDefault();
        }
    }
}
