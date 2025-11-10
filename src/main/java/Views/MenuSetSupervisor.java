package Views;

import Dominio.Funcionario.Supervisor.ObjetosDeValor.MetaMensal;
import Util.Ferramentas;
import ProjetoBase.SupervisorValidator;
import java.util.InputMismatchException;

public class MenuSetSupervisor {
    private static final SupervisorValidator supervisorValidator = new SupervisorValidator();

    public static MetaMensal MenuSetMetaMensal(){
        // Garantia de inicialização
        double metaMensal;

        // Menuzinho
        while(true) {
            System.out.print("┃ ➤ Digite a meta mensal: R$");

            try
            {
                double valorMetaMensal = Ferramentas.lDouble();
                return new MetaMensal(valorMetaMensal);
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
