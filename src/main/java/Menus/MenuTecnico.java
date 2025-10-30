package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.TecnicoModel;

import java.util.InputMismatchException;

public class MenuTecnico
{
    public static void menuTecnico(TecnicoModel tecnico)
    {
        boolean continuar = true;

        while(!continuar)
        {
            System.out.println("|=================================|");
            System.out.println("|=========  MENU TÉCNICO  ========|");
            System.out.println("|=================================|");
            System.out.println(" ");
            System.out.println("|  1 - Detalhes de uma OS         |");
            System.out.println("|  2 - Atualizar status de OS's   |");
            System.out.println("|  3 - Retornar ao menu inicial   |");
            System.out.println("|=================================|");
            System.out.print("|  Escolha: ");

            try
            {
                int escolhaTecnica = Ferramentas.lInteiro();

                switch(escolhaTecnica)
                {
                    case 1 -> MenuTecnicoVisualizarDetalhes.visualizarDetalhesDeOS();
                    case 2 -> MenuTecnicoAtualizarStatus.atualizarStatusDeSOs();
                    case 3 ->
                    {
                        System.out.println("|  RETORNANDO AO MENU INICIAL ...");
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
