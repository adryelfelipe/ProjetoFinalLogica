package Views;

import Models.joias.Especialidade;
import ProjetoBase.TecnicoValidator;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetTecnico {

    public static Especialidade MenuSetEspecialidade()
    {
        boolean verifica = false;
        int opcao = 0;

        while(true) {
            System.out.println(" ");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.println("┃    SELECIONE A ESPECIALIDADE   ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃ 1 - Técnico eletrotécnica      ┃");
            System.out.println("┃ 2 - Eletricista Fabril         ┃");
            System.out.println("┃ 3 - Soldador                   ┃");
            System.out.println("┃ 4 - Eletromecânica             ┃");
            System.out.println("┃ 5 - Pintor Industrial          ┃");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.print("┃ ➤ Escolha: ");

            try {
                opcao = Ferramentas.lInteiro();
                if(opcao > 5 || opcao < 1) {
                   Ferramentas.menuDefault();
                } else {
                    Especialidade especialidade = switch (opcao) {
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
}
