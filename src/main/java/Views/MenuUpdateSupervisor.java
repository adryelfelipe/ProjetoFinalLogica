package Views;

import Models.OrdemDeServicoModel;
import Models.SupervisorModel;
import Models.joias.StatusOS;
import ProjetoBase.OrdemDeServicoService;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuUpdateSupervisor
{
    public static final OrdemDeServicoService ordemDeServicoService = new OrdemDeServicoService();

    public static void menuUpdateOS(SupervisorModel supervisor) {
        long idOrdem;
        int UpdateOs = 0;
        boolean verifica = false;

        try {
            idOrdem = MenuEscolhaId.escolhaIdOs();
        } catch (
                InputMismatchException e) {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        OrdemDeServicoModel ordemDeServico = ((OrdemDeServicoModel) ordemDeServicoService.findById(idOrdem));

        while (true) {

            while (!verifica) {

                System.out.println("\n                                                 \n");
                System.out.println("         ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓          ");
                System.out.println("         ┃   ATUALIZAR ORDEM DE SERVIÇO   ┃          ");
                System.out.println("         ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛          ");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃   EDITAR   ORDEM   ┃         ┃            ATUAL           ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println(String.format("┃  1 - Status        ┃         ┃  %-26s┃" + ordemDeServico.getStatusDaOrdem()));
                System.out.println(String.format("┃  2 - Descrição     ┃         ┃  %-26s┃" + ordemDeServico.getDescricao()));
                System.out.println(String.format("┃  3 - Maquina       ┃         ┃  %-26s┃" + ordemDeServico.getIdMaquina()));
                System.out.println(String.format("┃  4 - Tecnico       ┃         ┃  %-26s┃" + ordemDeServico.getIdTecnico()));
                System.out.println(String.format("┃  5 - Valor         ┃         ┃  %-26s┃" + ordemDeServico.getValorDaOrdemDeServico()));
                System.out.println("┃  6 - Sair do Menu  ┃         ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃ ➤ Escolha:  ");

                try {
                    UpdateOs = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e)
                {
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch (UpdateOs) {
                case 1 -> {
                    StatusOS statusOS = MenuSetOrdemDeServico.menuSetStatusOS();
                    ordemDeServicoService.updateStatusOS(supervisor, idOrdem, statusOS);
                    ordemDeServico.setStatusDaOrdem(statusOS);
                }

                case 2 -> {
                    String descricao = MenuSetOrdemDeServico.SetDescricao();
                    ordemDeServicoService.updateDescricaoOS(supervisor, idOrdem, descricao);
                    ordemDeServico.setDescricao(descricao);
                }

                case 3 -> {
                    long idMaquina = MenuSetMaquina.SetIdMaquina();
                    ordemDeServicoService.updateIdMaquinaOS(supervisor, idOrdem, idMaquina);
                    ordemDeServico.setIdMaquina(idMaquina);
                }
                case 4 -> {
                    long idTecnico = MenuSetOrdemDeServico.SetIdTecnico();
                    ordemDeServicoService.updateIdTecnico(supervisor, idOrdem, idTecnico);
                    ordemDeServico.setIdTecnico(idTecnico);
                }
                case 5 -> {
                    double valorOS = MenuSetOrdemDeServico.SetValorOS();
                    ordemDeServicoService.updateValorOS(supervisor, idOrdem, valorOS);
                    ordemDeServico.setValorDaOrdemDeServico(valorOS);
                }
                case 6 -> {
                    return;
                }
                default -> Ferramentas.menuDefault();
            }
        }
    }
}