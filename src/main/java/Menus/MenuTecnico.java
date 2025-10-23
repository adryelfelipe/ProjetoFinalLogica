package Menus;

import ProjetoBase.Ferramentas;

import java.sql.SQLOutput;
import java.util.InputMismatchException;

public class MenuTecnico
{
    public static void menuTecnico()
    {
        boolean continuar = true;

        while(!continuar) {
            System.out.println("  |================================|");
            System.out.println("  |========  MENU TÉCNICO  ========|");
            System.out.println("  |================================|");

            System.out.println("| 1 - Listar minhas Ordens de Serviço");
            System.out.println("| 2 - Visualizar detalhes de uma Ordem de Serviço");
            System.out.println("| 3 - Atualizar status de uma Ordem de Serviço");
            System.out.println("| 4 - Registrar custos de manutenção");
            System.out.println("| 5 - Retornar ao menu inicial");
            System.out.print("| Escolha: ");

            try
            {
                int escolhaTecnica = Ferramentas.lInteiro();

                switch (escolhaTecnica){
                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:
                        System.out.println("RETORNANDO AO MENU INICIAL! . . .");
                        return;
                }
            }
            catch (InputMismatchException e)
            {
                Ferramentas.menuDefault();
            }
        }
    }
}
