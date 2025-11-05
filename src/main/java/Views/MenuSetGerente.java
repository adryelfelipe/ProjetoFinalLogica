package Views;

import Models.joias.Departamento;
import Util.Ferramentas;
import ProjetoBase.GerenteValidator;

import java.util.InputMismatchException;

public class MenuSetGerente {

    public static Departamento menuSetDepartamento()
    {
        int opcao;

        while(true)
        {
            System.out.println("|--------------------------------|");
            System.out.println("|  -  Escolha o Departamento  -  |");
            System.out.println("|--------------------------------|");
            System.out.println("|                                |");
            System.out.println("|  1 - Elétrica                  |");
            System.out.println("|  2 - Mecânica                  |");
            System.out.println("|--------------------------------|");
            System.out.print("|  Escolha: ");

            try {
                opcao = Ferramentas.lInteiro();
                if(opcao > 2 || opcao < 1) {
                    Ferramentas.menuDefault();
                } else {
                    Departamento departamento = switch (opcao){
                        case 1 -> Departamento.ELETRICA;
                        default -> Departamento.MECANICA;
                    };

                    GerenteValidator.verificaRegrasDepartamento(departamento);
                    GerenteValidator.verificaIntegridadeDepartamento(departamento);
                    return departamento;
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
