package Views.Administrador;

import Models.Administrador;
import Util.Ferramentas;
import Views.Nucleo.MenuInicial;

public class MenuAdministrador {
    public static void menuInicial(Administrador administrador) {
        boolean continuar = false;

        while (!continuar) {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                 "+Ferramentas.ORANGE_DARK+"MENU ADMINISTRADOR"+Ferramentas.AQUA_BLUE+"                ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Criar Gerente"+Ferramentas.AQUA_BLUE+"                                ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Atualizar Gerente"+Ferramentas.AQUA_BLUE+"                            ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Remover Gerente"+Ferramentas.AQUA_BLUE+"                              ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Retornar"+Ferramentas.AQUA_BLUE+"                                     ┃");
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
