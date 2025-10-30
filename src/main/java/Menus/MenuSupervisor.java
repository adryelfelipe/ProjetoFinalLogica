package Menus;

import ProjetoBase.Ferramentas;

import java.sql.SQLOutput;
import java.util.InputMismatchException;

public class MenuSupervisor
{
    public static void menuSupervisor()
    {
        boolean continuar = false;
        int opcao = 0;


        while(!continuar)
        {
            System.out.println("|================================|");
            System.out.println("|=======  MENU SUPERVISOR  ======|");
            System.out.println("|================================|");
            System.out.println(" ");
            System.out.println("| 1 - Criar nova Ordem de Serviço");
            System.out.println("| 2 - Acompanhar status das OS");
            System.out.println("| 3 - Retornar ao menu inicial");
            System.out.print("| Escolha: ");

            try
            {
                opcao = Ferramentas.lInteiro();

                switch (opcao)
                {
                    case 1:
                    {
                        MenuSupervisorCriarOS.criarOrdemDeServico();
                        break;
                    }
                    case 2:
                    {
                        MenuSupervisorAcompanharStatus.acompanharStatus();
                        break;
                    }
                    case 3:
                    {
                        System.out.println("RETORNANDO AO MENU INICIAL! . . .");
                        continuar = true;
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
