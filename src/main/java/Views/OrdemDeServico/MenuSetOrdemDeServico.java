package Views.OrdemDeServico;

import Dominio.OrdemDeServico.Enumeracoes.StatusOS;

import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetOrdemDeServico {
    public static StatusOS menuSetStatusOS() {
        while(true)
        {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                 "+Ferramentas.ORANGE_DARK+"ESCOLHA O STATUS DA OS"+Ferramentas.AQUA_BLUE+"                 ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Em Andamento"+Ferramentas.AQUA_BLUE+"                                      ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Atrasada"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Fechada"+Ferramentas.AQUA_BLUE+"                                           ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

            try
            {
                int opcao = Ferramentas.lInteiro();
                if(opcao > 3 || opcao < 1)
                {
                    Ferramentas.menuDefault();
                } else
                {
                    return switch (opcao)
                    {
                        case 1 -> StatusOS.ABERTA;
                        case 2 -> StatusOS.EM_ANDAMENTO;
                        default -> StatusOS.FECHADA;
                    };
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }

    public static long SetIdTecnico(){
        int idTecnico;

        while(true) {
            System.out.print("┃ ➤ Digite o ID do técnico: ");

            try {
                return Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }

    public static String SetDescricao() {
        System.out.print("┃ ➤ Digite a descrição da OS: ");
        return Ferramentas.lString();
    }

    public static double SetValorOS() {
        while(true) {
            System.out.print("┃ ➤ Digite o valor da OS: R$");

            try {
                return Ferramentas.lDouble();
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }

    public static long SetIdSupervisor() {
        while(true) {
            System.out.print("┃ ➤ Digite o ID do Supervisor: ");
            try {
                return Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
