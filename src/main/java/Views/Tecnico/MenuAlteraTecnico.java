package Views.Tecnico;

import Models.Enumeracoes.StatusMaquina;
import Models.Enumeracoes.StatusOS;
import Service.Validator.MaquinaValidator;
import Service.Validator.OrdemDeServicoValidator;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuAlteraTecnico
{
    public static StatusOS MenuSetStatusOrdemDeServico()
    {
        while(true) {
            int opcao;

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  1 - ABERTA                                       ┃");
            System.out.println("┃  2 - EM ANDAMENTO                                 ┃");
            System.out.println("┃  3 - FECHADA                                      ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha o Status: ");

            try {
                opcao = Ferramentas.lInteiro();

                if(opcao > 3 || opcao < 1) {
                    Ferramentas.menuDefault();
                } else
                {
                    StatusOS status = switch(opcao)
                    {
                        case 1 -> StatusOS.ABERTA;
                        case 2 -> StatusOS.EM_ANDAMENTO;
                        default -> StatusOS.FECHADA;
                    };

                    OrdemDeServicoValidator.verificaIntegridadeStatus(status);
                    OrdemDeServicoValidator.verificaRegrasStatus(opcao);
                    return status;
                }
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
