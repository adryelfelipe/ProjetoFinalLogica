package Views.Funcionario.Supervisor;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSupervisor
{
    public static void menuSupervisor(long idSupervisor, NivelAcesso nivelAcesso) {
        while(true) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                     MENU SUPERVISOR                    ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                      ┃");
            System.out.println("┃  1 - Cadastrar Nova Ordem            ┃");
            System.out.println("┃  2 - Visualizar Relatórios           ┃");
            System.out.println("┃  3 - Retornar                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcao = Ferramentas.lInteiro();

                switch (opcao) {
                    case 1 -> MenuCadastroSupervisor.menuCadastroOrdemCorretiva(idSupervisor, nivelAcesso);
                    case 2 -> MenuRelatorioSupervisor.menuRelatorio(idSupervisor, nivelAcesso);
                    case 3 -> {
                        Ferramentas.limpaTerminal();
                        System.out.print("┃  RETORNANDO AO MENU INICIAL! . . .");
                        Ferramentas.Delay(500);
                        Ferramentas.limpaTerminal();
                        return;
                    }
                    default -> Ferramentas.menuDefault();
                }
            }
            catch (InputMismatchException e) {
                Ferramentas.menuDefault();
                Ferramentas.limpaTerminal();
            }
        }
    }
}