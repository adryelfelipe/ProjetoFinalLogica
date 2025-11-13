package Views.OrdemDeServico;

import Dominio.OrdemDeServico.Enumeracoes.StatusOS;

import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetOrdemDeServico {
    public static StatusOS menuSetStatusOS() {
        while(true)
        {
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.println("┃     ESCOLHA O STATUS DA OS     ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃  1 - Em Andamento              ┃");
            System.out.println("┃  2 - Atrasada                  ┃");
            System.out.println("┃  3 - Fechada                   ┃");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.print("┃ ➤ Escolha: ");

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
                        case 1 -> StatusOS.EM_ANDAMENTO;
                        case 2 -> StatusOS.ATRASADA;
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
            System.out.println("┃ ➤ Digite o ID do técnico: ");

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
            System.out.println("┃ ➤ Digite o ID do Supervisor: ");
            try {
                return Ferramentas.lInteiro();
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
