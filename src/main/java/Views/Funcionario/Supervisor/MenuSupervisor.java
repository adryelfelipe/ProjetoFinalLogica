package Views.Funcionario.Supervisor;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Dominio.Funcionario.Supervisor.Supervisor;

import java.util.InputMismatchException;

public class MenuSupervisor
{
    public static void menuSupervisor(long idSupervisor, NivelAcesso nivelAcesso) {
        while(true) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃           MENU SUPERVISOR            ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                      ┃");
            System.out.println("┃  1 - Cadastrar Nova Ordem            ┃");
            System.out.println("┃  2 - Visualizar Relatórios           ┃");
            System.out.println("┃  3 - Retornar                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcao = Ferramentas.lInteiro();

                switch (opcao) {
                    case 1 -> MenuCadastroSupervisor.menuCadastroOrdem(idSupervisor, nivelAcesso);
                    case 2 -> MenuVisualizarOs.visualizarOs(idSupervisor, nivelAcesso);
                    case 3 -> {
                        System.out.println("RETORNANDO AO MENU INICIAL! . . .");
                        Ferramentas.Delay(500);
                        return;
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