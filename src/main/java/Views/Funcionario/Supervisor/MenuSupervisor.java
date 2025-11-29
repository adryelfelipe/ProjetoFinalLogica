package Views.Funcionario.Supervisor;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSupervisor
{
    public static void menuSupervisor(long idSupervisor, NivelAcesso nivelAcesso) {
        while(true) {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                     "+Ferramentas.ORANGE_DARK+"MENU SUPERVISOR"+Ferramentas.AQUA_BLUE+"                    ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Cadastrar Nova Ordem"+Ferramentas.AQUA_BLUE+"                              ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Visualizar Relatórios"+Ferramentas.AQUA_BLUE+"                             ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Retornar"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcao = Ferramentas.lInteiro();

                Ferramentas.limpaTerminal();
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