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

    public static String MenuSetLocalizacao() {
        System.out.print("┃ ➤ Digite a Localização: ");
        return Ferramentas.lString();
    }

    public static StatusMaquina MenuSetStatusMaquina() {
        while(true) {
            System.out.println("┃  1 - FUNCIONANDO               ┃");
            System.out.println("┃  2 - DEFEITO                   ┃");
            System.out.println("┃  3 - EM_MANUTENÇÃO             ┃");
            System.out.print("┃ ➤ Escolha o Status: ");

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
            System.out.println("┃ ➤ Digite o ID da máquina: ");

            try {
                return Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
