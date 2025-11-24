package Views.Gerente;

import Models.Enumeracoes.Especialidade;
import Service.Validator.SupervisorValidator;
import Service.Validator.TecnicoValidator;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuAtualizarGerente {

    private static final SupervisorValidator supervisorValidator = new SupervisorValidator();

    //                    ATUALIZA O TÉCNICO                    //
    public static Especialidade MenuSetEspecialidade()
    {
        //                    GARANTIA DE INICIAÇÃO                    //
        int opcao = 0;

        //                    MENUZINHO                    //
        while(true) {
            System.out.println(" ");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                    ATUALIZAR OS                   ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃  1 - Técnico eletrotécnica                        ┃");
            System.out.println("┃  2 - Eletricista Fabril                           ┃");
            System.out.println("┃  3 - Soldador                                     ┃");
            System.out.println("┃  4 - Eletromecânica                               ┃");
            System.out.println("┃  5 - Pintor Industrial                            ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃  Escolha: ");

            try {
                opcao = Ferramentas.lInteiro();
                if(opcao > 5 || opcao < 1) {
                   Ferramentas.menuDefault();
                } else {
                    Especialidade especialidade = switch (opcao)
                    {
                        case 1 -> Especialidade.TECNICO_ELETROTECNICA;
                        case 2 -> Especialidade.ELETRICISTA_FABRIL;
                        case 3 -> Especialidade.SOLDADOR;
                        case 4 -> Especialidade.TECNICO_ELETROMECANICA;
                        default -> Especialidade.PINTOR_INDUSTRIAL;
                    };

                    TecnicoValidator.verificaRegrasEspecialidade(especialidade);
                    TecnicoValidator.verificaIntegridadeEspecialidade(especialidade);
                    return especialidade;
                }
            } catch (IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();;
            }
        }
    }

    //                    ATUALIZA O SUPERVISOR                    //
    public static double MenuSetMetaMensal(){
        //                    GARANTIA DE INICIAÇÃO                    //
        double metaMensal;

        //                    MENUZINHO                    //
        while(true) {
            System.out.print("┃  Digite a meta mensal: R$");

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
