package Views.Funcionario.Gerente;


import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Util.Ferramentas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class MenuSetGerente {

    public static ArrayList<Departamento> menuSetDepartamento()
    {
        int opcao;

        while(true)
        {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                 "+Ferramentas.ORANGE_DARK+"ESCOLHA O DEPARTAMENTO"+Ferramentas.AQUA_BLUE+"                 ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Elétrica"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Mecânica"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

            try {
                opcao = Ferramentas.lInteiro();
                if(opcao > 2 || opcao < 1) {
                    Ferramentas.menuDefault();
                } else {
                    return switch (opcao){
                        case 1 -> new ArrayList<>(Arrays.asList(Departamento.ELETRICA));
                        default -> new ArrayList<>(Arrays.asList(Departamento.MECANICA));
                    };
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
