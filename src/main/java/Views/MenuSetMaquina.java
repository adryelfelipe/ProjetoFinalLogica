package Views;

import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.ObjetosDeValor.Localizacao;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import Util.Ferramentas;


import java.util.InputMismatchException;

public class MenuSetMaquina {
    //SET NOME DO USUÁRIO
    public static NomeMaquina MenuSetNomeMaquina() {
        System.out.print("┃ ➤ Digite o Nome: ");
        String nome = Ferramentas.lString();
        return new NomeMaquina(nome);
    }

    public static Localizacao MenuSetLocalizacao() {
        System.out.print("┃ ➤ Digite a Localização: ");
        String localizacao = Ferramentas.lString();
        return new Localizacao(localizacao);
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
        while(true)
        {
            System.out.println("┃ ➤ Digite o ID da máquina: ");

            try {
                return Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
