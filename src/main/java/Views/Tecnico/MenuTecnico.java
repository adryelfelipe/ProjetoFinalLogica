package Views.Tecnico;

import Util.Ferramentas;
import Models.Tecnico;
import Views.Nucleo.MenuInicial;

import java.util.InputMismatchException;

public class MenuTecnico
{
    public static void menuTecnico(Tecnico tecnico)
    {
        //                    GARANTIA DE INICIAÇÃO DE VARIÁVEIS                    //
        boolean continuar = true;

        while(!continuar)
        {
            //                    MENU                    //
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                    MENU TÉCNICO                   ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃  1 - Detalhes de uma ordem de seviço              ┃");
            System.out.println("┃  2 - Atualizar status de ordem de serviços        ┃");
            System.out.println("┃  3 - Retornar                                     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try
            {
                int escolhaTecnica = Ferramentas.lInteiro();

                switch(escolhaTecnica)
                {
                    case 1 -> MenuTecnicoVisualizarDetalhes.visualizarDetalhesDeOS();
                    case 2 -> MenuUpdateTecnico.menuUpdateOS(tecnico);
                    case 3 ->
                    {
                        System.out.println("┃  RETORNANDO AO MENU INICIAL ...");
                        MenuInicial.Menu();
                    }
                    default -> Ferramentas.menuDefault();
                }
            }
            catch (InputMismatchException e)
            {
                Ferramentas.menuDefault();
            }
        }
    }
}
