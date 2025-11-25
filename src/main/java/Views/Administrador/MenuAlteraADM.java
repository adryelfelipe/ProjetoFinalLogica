package Views.Administrador;

import Models.Enumeracoes.Departamento;
import Util.Ferramentas;
import Service.Validator.GerenteValidator;

import java.util.InputMismatchException;

public class MenuAlteraADM {

    public static Departamento menuSetDepartamento()
    {
        int opcao;

        while(true)
        {
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃              "+Ferramentas.ORANGE_DARK+"ESCOLHA O DEPARTAMENTO"+Ferramentas.AQUA_BLUE+"               ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Elétrica"+Ferramentas.AQUA_BLUE+"                                     ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Mecânica"+Ferramentas.AQUA_BLUE+"                                     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

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
