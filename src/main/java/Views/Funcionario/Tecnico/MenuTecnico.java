package Views.Funcionario.Tecnico;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuTecnico {
    public static void menuTecnico(long idTecnico, NivelAcesso nivelAcesso) {
        while(true) {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                      "+Ferramentas.ORANGE_DARK+"MENU TÉCNICO"+Ferramentas.AQUA_BLUE+"                      ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Visualizar Ordens de Serviço"+Ferramentas.AQUA_BLUE+"                      ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Retornar"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

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
