package Menus;

import ProjetoBase.Ferramentas;

import java.util.InputMismatchException;

public class MenuSupervisor
{
    public static void menuSupervisor(){
        boolean continuar = true;
        int opcao = 0;


        while(!continuar){
            System.out.println("| 1 - Criar nova Ordem de Serviço");
            System.out.println("| 2 - Acompanhar status das OS");
            System.out.println("| 3 - Retornar ao menu inicial");
            System.out.print("| Escolha: ");

            try{
                opcao = Ferramentas.lInteiro();

                switch (opcao){
                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:
                        System.out.println("RETORNANDO AO MENU INICIAL! . . .");
                        return;
                }

            }catch (InputMismatchException e){
                Ferramentas.menuDefault();
            }
        }
    }
}
