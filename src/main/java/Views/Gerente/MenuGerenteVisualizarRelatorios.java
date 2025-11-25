package Views.Gerente;

import Util.Ferramentas;

public class MenuGerenteVisualizarRelatorios
{
    public static void visualizarRelatorios()
    {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃               "+Ferramentas.ORANGE_DARK+"VISUALIZAR RELATÓRIOS"+Ferramentas.AQUA_BLUE+"               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ ➤ Digite o ID da ordem de serviço: ");

        try
        {

        }
        catch(IllegalArgumentException | IllegalStateException e)
        {
            Ferramentas.menuDefault();
        }
    }
}
