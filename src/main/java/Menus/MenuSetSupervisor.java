package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.SupervisorValidator;
import java.util.InputMismatchException;

public class MenuSetSupervisor {

    public static double MenuSetMetaMensal(SupervisorValidator supervisorValidator){
        // Garantia de inicialização
        double metaMensal;

        // Menuzinho
        while(true) {
            System.out.print("Digite a meta mensal: ");

            try {
                metaMensal = Ferramentas.lDouble();
                supervisorValidator.verificaIntegridadeMetaMensal(metaMensal);
                supervisorValidator.verificaRegrasMetaMensal(metaMensal);
                return metaMensal;
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
