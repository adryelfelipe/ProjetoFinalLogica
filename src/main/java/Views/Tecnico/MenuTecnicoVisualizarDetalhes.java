package Views.Tecnico;

import Util.Ferramentas;

public class MenuTecnicoVisualizarDetalhes
{
    public static void visualizarDetalhesDeOS()
    {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃      "+Ferramentas.ORANGE_DARK+"VISUALIZAR DETALHES DA ORDEM DE SERVIÇO"+Ferramentas.AQUA_BLUE+"      ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        try{

        }catch (IllegalArgumentException | IllegalStateException e){
            Ferramentas.menuDefault();
        }
    }
}
