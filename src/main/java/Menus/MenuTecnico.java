package Menus;

import ProjetoBase.Ferramentas;

import java.sql.SQLOutput;
import java.util.InputMismatchException;

public class MenuTecnico
{
    public static void menuTecnico()
    {
        boolean continuar = true;

        while(!continuar) {
            System.out.println("  |================================|");
            System.out.println("  |========  MENU TÉCNICO  ========|");
            System.out.println("  |================================|");

            System.out.println("| 1 - Visualizar detalhes de uma Ordem de Serviço");
            System.out.println("| 2 - Atualizar status de uma Ordem de Serviço");
            System.out.println("| 3 - Retornar ao menu inicial");
            System.out.print("| Escolha: ");

            try
            {
                int escolhaTecnica = Ferramentas.lInteiro();

                switch (escolhaTecnica)
                {
                    case 1:
                    {
                        MenuTecnicoVisualizarDetalhes.visualizarDetalhesDeOS();
                        break;
                    }
                    case 2:
                    {
                        MenuTecnicoAtualizarStatus.atualizarStatusDeSOs();
                        break;
                    }
                    case 3:
                    {
                        System.out.println("|  RETORNANDO AO MENU INICIAL ...");
                        MenuInicial.Menu();
                        break;
                    }
                }
            }
            catch (InputMismatchException e)
            {
                Ferramentas.menuDefault();
            }
        }
    }
}
