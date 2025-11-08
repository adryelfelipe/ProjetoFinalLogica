package Views;

import Models.AdminModel;
import Util.Ferramentas;

public class MenuAdministrador {
    public static void menuInicial(AdminModel adminModel) {
        boolean continuar = false;

        while (!continuar) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃      MENU ADMINISTRADOR        ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃  1 - Criar Gerente             ┃");
            System.out.println("┃  2 - Atualizar Gerente         ┃");
            System.out.println("┃  3 - Remover Gerente           ┃");
            System.out.println("┃  4 - Retornar                  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try
            {
                int opcaoAdmin = Ferramentas.lInteiro();

                switch (opcaoAdmin)
                {
                    case 1 -> MenuCadastroADM.menuCadastroGerente(adminModel);
                    case 2 -> MenuUpdateADM.updateGerente(adminModel);
                    case 3 -> MenuAdminRemoverGerente.menuRemoverEscolha(adminModel);
                    case 4 -> MenuInicial.Menu();
                    default -> Ferramentas.menuDefault();
                }
            }
            catch(IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.menuDefault();
            }
        }

    }
}
