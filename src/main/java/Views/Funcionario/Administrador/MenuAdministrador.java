package Views.Funcionario.Administrador;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

public class MenuAdministrador {
    // -- Métodos -- //
    public static void menuInicial(long idAdm, NivelAcesso nivelAcesso) {

        while (true) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                   "+Ferramentas.ORANGE_DARK+"MENU ADMINISTRADOR"+Ferramentas.AQUA_BLUE+"                   ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Criar Gerente"+Ferramentas.AQUA_BLUE+"                                     ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Atualizar Gerente"+Ferramentas.AQUA_BLUE+"                                 ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Remover Funcionários"+Ferramentas.AQUA_BLUE+"                              ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Retornar"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

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

            Ferramentas.limpaTerminal();
        }
    }
}
