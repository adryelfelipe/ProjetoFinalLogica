package Views;

import Util.Ferramentas;
import Dominio.Funcionario.Gerente.Gerente;
import Views.Gerente.MenuGerenteCadastrar;
import Views.Gerente.MenuGerenteRelatorios;
import Views.Gerente.MenuGerenteRemoverUsuarios;
import Views.Gerente.MenuUpdateGerente;

public class MenuGerente
{
    public static void menuInicial() {
        boolean continuar = false;

        while(!continuar) {
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

            try
            {
                int opcaoGerente = Ferramentas.lInteiro();

                Ferramentas.limpaTerminal();
                switch (opcaoGerente) {
                    case 1 -> MenuGerenteCadastrar.criarUsuarios();
                    case 2 -> MenuGerenteRelatorios.visualizarRelatorios();
                    case 3 -> MenuUpdateGerente.menuUpdateEscolha();
                    case 4 -> MenuGerenteRemoverUsuarios.menuRemoverEscolha();
                    case 5 ->
                    {
                        System.out.println("┃  RETORNANDO AO MENU INICIAL ...");
                        //MenuInicial.Menu();
                    }
                    default -> Ferramentas.menuDefault();
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
