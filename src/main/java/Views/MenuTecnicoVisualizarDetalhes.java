package Views;

import Util.Ferramentas;

public class MenuTecnicoVisualizarDetalhes
{
    public static void visualizarDetalhesDeOS()
    {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃      VISUALIZAR DETALHES DA ORDEM DE SERVIÇO      ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        try{

        }catch (IllegalArgumentException | IllegalStateException e){
            Ferramentas.menuDefault();
        }
    }
}
