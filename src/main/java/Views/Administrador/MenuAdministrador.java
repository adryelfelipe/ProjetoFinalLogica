package Views.Administrador;

import Models.Administrador;
import Util.Ferramentas;
import Views.Nucleo.MenuInicial;

public class MenuAdministrador {
    public static void menuInicial(Administrador administrador) {
        boolean continuar = false;

        while (!continuar) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                 MENU ADMINISTRADOR                ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃  1 - Criar Gerente                                ┃");
            System.out.println("┃  2 - Atualizar Gerente                            ┃");
            System.out.println("┃  3 - Remover Gerente                              ┃");
            System.out.println("┃  4 - Retornar                                     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try
            {
                int opcaoAdmin = Ferramentas.lInteiro();

                switch (opcaoAdmin)
                {
                    case 1 -> MenuCadastroADM.menuCadastroGerente(administrador);
                    case 2 -> MenuUpdateADM.updateGerente(administrador);
                    case 3 -> MenuAdminRemoverGerente.menuRemoverEscolha(administrador);
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
