package Views.Gerente;

import Util.Ferramentas;
import Models.Gerente;
import Views.Nucleo.MenuInicial;

public class MenuGerente
{
    public static void menuInicial(Gerente gerente)
    {
        boolean continuar = false;

        while(!continuar)
        {
            System.out.println(" ");

            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                    "+Ferramentas.ORANGE_DARK+"MENU GERENTE"+Ferramentas.AQUA_BLUE+"                   ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Cadastrar"+Ferramentas.AQUA_BLUE+"                                    ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Visualizar Relatórios"+Ferramentas.AQUA_BLUE+"                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Visualizar Ocorrências"+Ferramentas.AQUA_BLUE+"                       ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Atualizar Técnico/Supervisor"+Ferramentas.AQUA_BLUE+"                 ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"5 - Remover Técnico/Supervisor"+Ferramentas.AQUA_BLUE+"                   ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"6 - Retornar"+Ferramentas.AQUA_BLUE+"                                     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try
            {
                int opcaoGerente = Ferramentas.lInteiro();

                Ferramentas.limpaTerminal();
                switch (opcaoGerente) {
                    case 1 -> MenuGerenteCadastrar.criarUsuarios(gerente);
                    case 2 -> MenuGerenteVisualizarRelatorios.visualizarRelatorios();
                    case 3 -> MenuGerenteVisualizarOcorrencias.visualizarOcorrencias();
                    case 4 -> MenuUpdateGerente.menuUpdateEscolha(gerente);
                    case 5 -> MenuGerenteRemoverUsuarios.menuRemoverEscolha(gerente);
                    case 6 ->
                    {
                        System.out.println(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  RETORNANDO AO MENU INICIAL ..."+Ferramentas.RESET+Ferramentas.AQUA_BLUE);

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
