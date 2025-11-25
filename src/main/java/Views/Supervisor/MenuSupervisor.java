package Views.Supervisor;
/*
import Util.Ferramentas;
import Models.Supervisor;
import Views.Nucleo.MenuInicial;

import java.util.InputMismatchException;

public class MenuSupervisor
{
    public static void menuSupervisor(Supervisor supervisor)
    {
        //                    GARANTIA DE INICIAÇÃO DE VARIÁVEIS                    //
        boolean continuar = false;
        int opcao = 0;

        while(!continuar) {
            //                    MENU                    //
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                   "+Ferramentas.ORANGE_DARK+"MENU SUPERVISOR"+Ferramentas.AQUA_BLUE+"                 ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"1 - Cadastrar nova OS"+Ferramentas.AQUA_BLUE+"                             ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"2 - Acompanhar status das OS"+Ferramentas.AQUA_BLUE+"                      ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"3 - Retornar ao menu inicial"+Ferramentas.AQUA_BLUE+"                      ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                opcao = Ferramentas.lInteiro();

                switch (opcao) {
                    case 1 -> MenuCadastroSupervisor.menuCadastroOrdem(supervisor);
                    case 2 -> MenuSupervisorAcompanharStatus.acompanharStatus(supervisor);
                    case 3 -> {
                        System.out.println(Ferramentas.AQUA_BLUE+"┃  RETORNANDO AO MENU INICIAL! . . .");
                        Ferramentas.Delay(500);
                        continuar = true;
                        MenuInicial.Menu();
                    }
                    default -> Ferramentas.menuDefault();
                }
            }
            catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}*/