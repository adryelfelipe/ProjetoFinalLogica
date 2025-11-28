package Views.Funcionario.Gerente;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuGerente {
    public static void menuInicial(long idGerente, NivelAcesso nivelAcesso) {

        while(true) {

            System.out.println("                                                          ");
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                      "+Ferramentas.ORANGE_DARK+"MENU GERENTE"+Ferramentas.AQUA_BLUE+"                      ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Cadastrar"+Ferramentas.AQUA_BLUE+"                                         ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Visualizar Relatórios"+Ferramentas.AQUA_BLUE+"                             ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Atualizar Funcionários"+Ferramentas.AQUA_BLUE+"                            ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Remover Funcionários"+Ferramentas.AQUA_BLUE+"                              ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"5 - Remover Máquinas"+Ferramentas.AQUA_BLUE+"                                  ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"6 - Retornar"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

            try {
                int opcaoGerente = Ferramentas.lInteiro();

                Ferramentas.limpaTerminal();
                switch (opcaoGerente) {
                    case 1 -> MenuGerenteCadastrar.criarUsuarios(nivelAcesso);
                    case 2 -> MenuRelatorio.menuRelatorio(idGerente, nivelAcesso);
                    case 3 -> MenuUpdateGerente.menuUpdateEscolha(nivelAcesso);
                    case 4 -> MenuGerenteRemoverUsuarios.menuRemoverEscolha(idGerente, nivelAcesso);
                    case 5 -> MenuExcluirMaquina.menuRemoverEscolha(idGerente, nivelAcesso);
                    case 6 -> {
                        System.out.print(Ferramentas.ITALIC+Ferramentas.DARK_CYAN+"┃  RETORNANDO AO MENU INICIAL ..."+Ferramentas.RESET+Ferramentas.AQUA_BLUE);
                        Ferramentas.Delay(500);
                        Ferramentas.limpaTerminal();
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }

            Ferramentas.limpaTerminal();
        }
    }
}
