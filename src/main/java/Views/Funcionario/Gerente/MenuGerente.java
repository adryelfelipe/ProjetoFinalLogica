package Views.Funcionario.Gerente;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuGerente {
    public static void menuInicial(long idGerente, NivelAcesso nivelAcesso) {

        while(true) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃             MENU GERENTE             ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                      ┃");
            System.out.println("┃  1 - Cadastrar                       ┃");
            System.out.println("┃  2 - Visualizar Relatórios           ┃");
            System.out.println("┃  3 - Atualizar Funcionários          ┃");
            System.out.println("┃  4 - Remover Funcionários            ┃");
            System.out.println("┃  5 - Retornar                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcaoGerente = Ferramentas.lInteiro();

                Ferramentas.limpaTerminal();
                switch (opcaoGerente) {
                    case 1 -> MenuGerenteCadastrar.criarUsuarios(nivelAcesso);
                    case 2 -> MenuRelatorio.menuRelatorio(idGerente, nivelAcesso);
                    case 3 -> MenuUpdateGerente.menuUpdateEscolha(nivelAcesso);
                    case 4 -> MenuGerenteRemoverUsuarios.menuRemoverEscolha(idGerente, nivelAcesso);
                    case 5 -> {
                        System.out.print("┃  RETORNANDO AO MENU INICIAL ...");
                        Ferramentas.Delay(500);
                        Ferramentas.limpaTerminal();
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }

            Ferramentas.limpaTerminal();
        }
    }
}
