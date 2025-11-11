package Views.Administrador;

import Aplicacao.Funcionario.Gerente.Controller.GerenteController;
import Aplicacao.Funcionario.Nucleo.Exceptions.AutorizacaoException;
import Dominio.Funcionario.Administrador.Administrador;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.MenuInicial;

public class MenuAdministrador {
    // -- Atributos -- //
    MenuCadastroADM menuCadastroADM;

    // -- Construtor -- //
    public MenuAdministrador(GerenteController gerenteController) {
        menuCadastroADM = new MenuCadastroADM(gerenteController);
    }

    // -- Métodos -- //
    public void menuInicial(NivelAcesso nivelAcesso) {
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

            try {
                int opcaoAdmin = Ferramentas.lInteiro();

                switch (opcaoAdmin) {
                    case 1 -> menuCadastroADM.menuCadastroGerente(nivelAcesso);
                    //case 2 -> MenuUpdateADM.updateGerente();
                    //case 3 -> MenuAdminRemoverGerente.menuRemoverEscolha();
                    //case 4 -> MenuInicial.Menu();
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
