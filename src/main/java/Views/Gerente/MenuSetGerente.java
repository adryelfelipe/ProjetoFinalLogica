package Views.Gerente;


import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.ObjetosDeValor.ListaDepartamentos;
import Util.Ferramentas;
import ProjetoBase.GerenteValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class MenuSetGerente {

    public static ArrayList<Departamento> menuSetDepartamento()
    {
        int opcao;

        while(true)
        {
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.println("┃  -  Escolha o Departamento  -  ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃  1 - Elétrica                  ┃");
            System.out.println("┃  2 - Mecânica                  ┃");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.print("┃ ➤ Escolha: ");

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
