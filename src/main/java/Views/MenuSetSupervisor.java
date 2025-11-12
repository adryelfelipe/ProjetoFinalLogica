package Views;

import Util.Ferramentas;
import java.util.InputMismatchException;

public class MenuSetSupervisor {
    public static double MenuSetMetaMensal(){
        // Garantia de inicialização
        double metaMensal;

        // Menuzinho
        while(true) {
            System.out.print("┃ ➤ Digite a meta mensal: R$");

            try
            {
                return Ferramentas.lDouble();
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
