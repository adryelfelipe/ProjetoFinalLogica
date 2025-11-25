package Views.Gerente;

import Models.Enumeracoes.Especialidade;
import Service.Validator.SupervisorValidator;
import Service.Validator.TecnicoValidator;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuAlteraGerente {

    private static final SupervisorValidator supervisorValidator = new SupervisorValidator();

    //                    ATUALIZA O TÉCNICO                    //
    public static Especialidade MenuSetEspecialidade()
    {
        //                    GARANTIA DE INICIAÇÃO                    //
        int opcao = 0;

        //                    MENUZINHO                    //
        while(true) {
            System.out.println(" ");
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                    "+Ferramentas.ORANGE_DARK+"ATUALIZAR OS"+Ferramentas.AQUA_BLUE+"                   ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Técnico eletrotécnica"+Ferramentas.AQUA_BLUE+"                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Eletricista Fabril"+Ferramentas.AQUA_BLUE+"                           ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Soldador"+Ferramentas.AQUA_BLUE+"                                     ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Eletromecânica"+Ferramentas.AQUA_BLUE+"                               ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"5 - Pintor Industrial"+Ferramentas.AQUA_BLUE+"                            ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

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
            System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite a meta mensal: R$");

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
