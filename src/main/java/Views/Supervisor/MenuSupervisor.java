package Views.Supervisor;

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
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                   MENU SUPERVISOR                 ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃ 1 - Cadastrar nova OS                             ┃");
            System.out.println("┃ 2 - Acompanhar status das OS                      ┃");
            System.out.println("┃ 3 - Retornar ao menu inicial                      ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                opcao = Ferramentas.lInteiro();

                switch (opcao) {
                    case 1 -> MenuCadastroSupervisor.menuCadastroOrdem(supervisor);
                    case 2 -> MenuSupervisorAcompanharStatus.acompanharStatus();
                    case 3 -> {
                        System.out.println("┃  RETORNANDO AO MENU INICIAL! . . .");
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
}