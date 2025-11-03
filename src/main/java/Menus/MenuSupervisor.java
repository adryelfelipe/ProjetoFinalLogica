package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.SupervisorModel;

import java.util.InputMismatchException;

public class MenuSupervisor
{
    public static void menuSupervisor(SupervisorModel supervisor)
    {
        boolean continuar = false;
        int opcao = 0;

        while(!continuar)
        {
            System.out.println("|================================|");
            System.out.println("|=======  MENU SUPERVISOR  ======|");
            System.out.println("|================================|");
            System.out.println("| 1 - Criar nova OS's            |");
            System.out.println("| 2 - Acompanhar status das OS   |");
            System.out.println("| 3 - Retornar ao menu inicial   |");
            System.out.println("|=================================|");
            System.out.print("| Escolha: ");

            try
            {
                opcao = Ferramentas.lInteiro();

                switch (opcao)
                {
                    case 1 -> MenuSupervisorCriarOS.criarOrdemDeServico();
                    case 2 -> MenuSupervisorAcompanharStatus.acompanharStatus();
                    case 3 ->
                    {
                        System.out.println("RETORNANDO AO MENU INICIAL! . . .");
                        continuar = true;
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