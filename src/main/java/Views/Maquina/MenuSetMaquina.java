package Views.Maquina;

import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Util.Ferramentas;


import java.util.InputMismatchException;

public class MenuSetMaquina {
    //SET NOME DO USUÁRIO
    public static String MenuSetNomeMaquina() {
        System.out.print("┃ ➤ Digite o Nome: ");
        return Ferramentas.lString();
    }

    public static StatusMaquina MenuSetStatusMaquina() {
        while(true) {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - FUNCIONANDO"+Ferramentas.AQUA_BLUE+"                                       ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - DEFEITO"+Ferramentas.AQUA_BLUE+"                                           ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - EM_MANUTENÇÃO"+Ferramentas.AQUA_BLUE+"                                     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha o Status: "+Ferramentas.AQUA_BLUE+" ");

            try {
                int opcao = Ferramentas.lInteiro();

                if(opcao > 3 || opcao < 1) {
                    Ferramentas.menuDefault();
                } else {
                    return switch(opcao){
                        case 1 -> StatusMaquina.FUNCIONANDO;
                        case 2 -> StatusMaquina.DEFEITO;
                        default -> StatusMaquina.EM_MANUTENCAO;
                    };
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }

    public static long SetIdMaquina(){
        while(true) {
            System.out.print("┃ ➤ Digite o ID da máquina: ");

            try {
                return Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
