package Views;

import Util.Ferramentas;
import Models.GerenteModel;

public class MenuGerente
{
    public static void menuInicial(GerenteModel gerenteModel)
    {
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
                    case 1 -> MenuGerenteCadastrar.criarUsuarios(gerenteModel);
                    case 2 -> MenuGerenteRelatorios.visualizarRelatorios();
                    case 3 -> MenuUpdateGerente.menuUpdateEscolha(gerenteModel);
                    case 4 -> MenuGerenteRemoverUsuarios.menuRemoverEscolha(gerenteModel);
                    case 5 ->
                    {
                        System.out.println("┃  RETORNANDO AO MENU INICIAL ...");
                        MenuInicial.Menu();
                    }
                    default -> Ferramentas.menuDefault();
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
