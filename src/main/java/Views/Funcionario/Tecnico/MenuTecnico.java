package Views.Funcionario.Tecnico;

import Dominio.Funcionario.Tecnico.Tecnico;
import Util.Ferramentas;
import Views.Funcionario.Nucleo.MenuInicial;

import java.util.InputMismatchException;

public class MenuTecnico
{
    public static void menuTecnico(Tecnico tecnico)
    {
        boolean continuar = false;

        while(!continuar)
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃             MENU TÉCNICO             ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                      ┃");
            System.out.println("┃  1 - Detalhes de uma Ordem           ┃");
            System.out.println("┃  2 - Atualizar Status de uma Ordem   ┃");
            System.out.println("┃  5 - Retornar                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try
            {
                int escolhaTecnica = Ferramentas.lInteiro();

                switch(escolhaTecnica)
                {
                    case 1 -> MenuTecnicoVisualizarDetalhes.visualizarDetalhesDeOS();
                     //case 2 -> MenuUpdateTecnico.menuUpdateOS(tecnico);
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
