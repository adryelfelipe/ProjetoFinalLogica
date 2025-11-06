package Views;

import Models.OrdemDeServicoModel;
import Models.TecnicoModel;
import Models.joias.Especialidade;
import Models.joias.StatusOS;
import ProjetoBase.OrdemDeServicoService;
import ProjetoBase.UsuarioService;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuUpdateTecnico
{
    public static final OrdemDeServicoService ordemDeServicoService = new OrdemDeServicoService();

    public static void menuUpdateOS(TecnicoModel tecnico)
    {
        long idOrdem;
        int UpdateOs = 0;
        boolean verifica = false;

        try
        {
            idOrdem = MenuEscolhaId.escolhaIdOs();
        }
        catch (InputMismatchException e)
        {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        OrdemDeServicoModel ordemDeServico = ((OrdemDeServicoModel) ordemDeServicoService.findById(idOrdem));

        while(true)
        {

            while(!verifica)
            {

                System.out.println("\n                                                 \n");
                System.out.println("         ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓          ");
                System.out.println("         ┃   ATUALIZAR ORDEM DE SERVIÇO   ┃          ");
                System.out.println("         ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛          ");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃   EDITAR   ORDEM   ┃         ┃        ATUAL       ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃  1 - Status        ┃         ┃Status: " + ordemDeServico.getStatusDaOrdem());
                System.out.println("┃  2 - Descrição     ┃         ┃Descrição: " + ordemDeServico.getDescricao());
                System.out.println("┃  3 - Maquina       ┃         ┃Maquina: " + ordemDeServico.getIdMaquina());
                System.out.println("┃  4 - Tecnico       ┃         ┃Técnico: " + ordemDeServico.getIdTecnico());
                System.out.println("┃  5 - Valor         ┃         ┃Valor: " + ordemDeServico.getValorDaOrdemDeServico());
                System.out.println("┃  6 - Sair do Menu  ┃         ┗━━━━━━━━━━━━━━━━━━━━");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("  Escolha:  ");

                try
                {
                    UpdateOs = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }

            // Reinicia a veriável de verificação
            verifica = false;

            switch(UpdateOs) {
                case 1 ->
                {
                    StatusOS statusOS = MenuSetOrdemDeServico.menuSetStatusOS();
                    ordemDeServicoService.updateStatusOS(tecnico, idOrdem, statusOS);
                    ordemDeServico.setStatusDaOrdem(statusOS);
                }

                case 2 -> {
                    String descricao = MenuSetOrdemDeServico.SetDescricao();
                    ordemDeServicoService.updateDescricaoOS(tecnico, idOrdem, descricao);
                    ordemDeServico.setDescricao(descricao);
                }

                case 3 -> {
                    long idMaquina = MenuSetMaquina.SetIdMaquina();
                    ordemDeServicoService.updateIdMaquinaOS(tecnico, idOrdem, idMaquina);
                    ordemDeServico.setIdMaquina(idMaquina);
                }
                case 4 -> {
                    long idTecnico = MenuSetOrdemDeServico.SetIdTecnico();
                    ordemDeServicoService.updateIdTecnico(tecnico, idOrdem, idTecnico);
                    ordemDeServico.setIdTecnico(idTecnico);
                }
                case 5 ->
                {
                    double valorOS = MenuSetOrdemDeServico.SetValorOS();
                    ordemDeServicoService.updateValorOS(tecnico, idOrdem, valorOS);
                    ordemDeServico.setValorDaOrdemDeServico(valorOS);
                }
                case 6 ->
                {
                    return;
                }
                default -> Ferramentas.menuDefault();
            }
        }
    }
}
