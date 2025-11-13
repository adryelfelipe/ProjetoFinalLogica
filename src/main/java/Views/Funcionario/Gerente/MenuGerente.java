package Views.Funcionario.Gerente;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuGerente {
    public static void menuInicial(NivelAcesso nivelAcesso) {

        while(true) {
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃            MENU GERENTE           ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃  1 - Cadastrar                    ┃");
            System.out.println("┃  2 - Visualizar Relatórios        ┃");
            System.out.println("┃  3 - Atualizar Técnico/Supervisor ┃");
            System.out.println("┃  4 - Remover Técnico/Supervisor   ┃");
            System.out.println("┃  5 - Retornar                     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcaoGerente = Ferramentas.lInteiro();

                Ferramentas.limpaTerminal();
                switch (opcaoGerente) {
                    case 1 -> MenuGerenteCadastrar.criarUsuarios(nivelAcesso);
                    case 2 -> MenuGerenteRelatorios.visualizarRelatorios();
                    case 3 -> MenuUpdateGerente.menuUpdateEscolha();
                    case 4 -> MenuGerenteRemoverUsuarios.menuRemoverEscolha();
                    case 5 -> {
                        System.out.println("┃  RETORNANDO AO MENU INICIAL ...");
                        Ferramentas.Delay(500);
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            } catch (InputMismatchException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
