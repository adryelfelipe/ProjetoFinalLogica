package Views;

import Util.Ferramentas;
import ProjetoBase.GerenteValidator;

import java.util.InputMismatchException;

public class MenuSetGerente {

    public static int menuSetDepartamento()
    {
        int opcao;

        while(true)
        {
            System.out.println("Escolha o Departamento: ");
            System.out.println("[1] - ELÉTRICA ");
            System.out.println("[2] - MECÂNICA ");

            try {
                opcao = Ferramentas.lInteiro();
                if(opcao > 2 || opcao < 1)
                {
                    Ferramentas.menuDefault();
                } else
                {
                    GerenteValidator.verificaIntegridadeIdDepartamento(opcao);
                    GerenteValidator.verificaRegrasIdDepartamento(opcao);
                    return opcao;
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
