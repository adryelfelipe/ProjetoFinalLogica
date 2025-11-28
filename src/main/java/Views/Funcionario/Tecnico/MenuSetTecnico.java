package Views.Funcionario.Tecnico;

import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetTecnico {

    public static Especialidade MenuSetEspecialidade()
    {
        while(true) {
            System.out.println(" ");
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃               "+Ferramentas.ORANGE_DARK+"SELECIONE A ESPECIALIDADE"+Ferramentas.AQUA_BLUE+"                ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"1 - Técnico eletrotécnica"+Ferramentas.AQUA_BLUE+"                              ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"2 - Eletricista Fabril"+Ferramentas.AQUA_BLUE+"                                 ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"3 - Soldador"+Ferramentas.AQUA_BLUE+"                                           ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"4 - Eletromecânica"+Ferramentas.AQUA_BLUE+"                                     ┃");
            System.out.println("┃ "+Ferramentas.ORANGE_DARK+"5 - Pintor Industrial"+Ferramentas.AQUA_BLUE+"                                  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

            try {
                int opcao = Ferramentas.lInteiro();
                if(opcao > 5 || opcao < 1) {
                   Ferramentas.menuDefault();
                } else {
                    return switch (opcao) {
                        case 1 -> Especialidade.TECNICO_ELETROTECNICA;
                        case 2 -> Especialidade.ELETRICISTA_FABRIL;
                        case 3 -> Especialidade.SOLDADOR;
                        case 4 -> Especialidade.TECNICO_ELETROMECANICA;
                        default -> Especialidade.PINTOR_INDUSTRIAL;
                    };
                }
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();;
            }
        }
    }
}
