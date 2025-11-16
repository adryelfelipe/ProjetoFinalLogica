package Views.Funcionario.Administrador;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

public class MenuAdministrador {
    // -- Métodos -- //
    public static void menuInicial(long idAdm, NivelAcesso nivelAcesso) {

        while (true) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃          MENU ADMINISTRADOR          ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                      ┃");
            System.out.println("┃  1 - Criar Gerente                   ┃");
            System.out.println("┃  2 - Atualizar Gerente               ┃");
            System.out.println("┃  3 - Remover Gerente                 ┃");
            System.out.println("┃  4 - Retornar                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcaoAdmin = Ferramentas.lInteiro();

                switch (opcaoAdmin) {
                    case 1 ->  MenuCadastroADM.menuCadastroGerente(nivelAcesso);
                    case 2 -> MenuUpdateADM.updateGerente(nivelAcesso);
                    case 3 -> MenuAdminRemoverGerente.menuRemoverEscolha(idAdm, nivelAcesso);
                    case 4 -> {
                        return;
                    }

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
