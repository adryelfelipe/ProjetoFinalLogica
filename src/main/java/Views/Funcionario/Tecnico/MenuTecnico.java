package Views.Funcionario.Tecnico;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuTecnico {
    public static void menuTecnico(long idTecnico, NivelAcesso nivelAcesso) {
        while(true) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                      MENU TÉCNICO                      ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  1 - Visualizar Ordens de Serviço                      ┃");
            System.out.println("┃  2 - Retornar                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int escolhaTecnica = Ferramentas.lInteiro();

                switch(escolhaTecnica) {
                    case 1 -> MenuTecnicoOs.ordensServicos(idTecnico, nivelAcesso);
                    case 2 -> {
                        Ferramentas.mensagemSucesso("┃  RETORNANDO AO MENU INICIAL ...");
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            }
            catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
