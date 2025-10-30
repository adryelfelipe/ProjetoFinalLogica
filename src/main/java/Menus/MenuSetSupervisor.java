package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.SupervisorValidator;
import java.util.InputMismatchException;

public class MenuSetSupervisor {
    private static final SupervisorValidator supervisorValidator = new SupervisorValidator();

    public static double MenuSetMetaMensal(){
        // Garantia de inicialização
        double metaMensal;

        // Menuzinho
        while(true) {
            System.out.print("Digite a meta mensal: ");

            try
            {
                metaMensal = Ferramentas.lDouble();
                SupervisorValidator.verificaIntegridadeMetaMensal(metaMensal);
                SupervisorValidator.verificaRegrasMetaMensal(metaMensal);
                return metaMensal;
            } catch(InputMismatchException e)
            {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e)
            {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
