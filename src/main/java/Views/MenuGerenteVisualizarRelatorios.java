package Views;

import Util.Ferramentas;

public class MenuGerenteVisualizarRelatorios
{
    public static void visualizarRelatorios()
    {
        System.out.println(" ");
        System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
        System.out.print("|  Digite o ID da Ordem de Serviço(SO): ");

        try
        {

        }
        catch(IllegalArgumentException | IllegalStateException e)
        {
            Ferramentas.menuDefault();
        }
    }
}
