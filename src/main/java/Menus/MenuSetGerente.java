package Menus;

import ProjetoBase.Departamento;
import ProjetoBase.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetGerente {

    public static int menuSetDepartamento() {
        int opcao;

        while(true) {
            System.out.println("Escolha o Departamento: ");
            System.out.println("1 - ELÉTRICA ");
            System.out.println("2 - MECÂNICA ");

            try {
                opcao = Ferramentas.lInteiro();
                if(opcao > 2 || opcao < 1) {
                    Ferramentas.menuDefault();
                } else {
                    return switch(opcao) {
                        case 1 -> Departamento.ELETRICA;
                        default -> Departamento.MECANICA;
                    };
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
