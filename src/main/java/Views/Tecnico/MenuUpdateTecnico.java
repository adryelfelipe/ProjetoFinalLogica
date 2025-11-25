package Views.Tecnico;
/*
import Models.Enumeracoes.StatusOS;
import Models.OrdemDeServico;
import Models.Tecnico;
import Models.Enumeracoes.Especialidade;
import Service.OrdemDeServicoService;
import Util.Ferramentas;
import Views.Gerente.MenuAlteraGerente;
import Views.Nucleo.MenuEscolhaId;
import Views.Nucleo.MenuAlteraUsuario;
import Views.Supervisor.MenuAlteraOrdemDeServico;

import java.util.InputMismatchException;

public class MenuUpdateTecnico
{
    //                    ATRIBUTOS                    //
    public static final OrdemDeServicoService ordemDeServicoService = new OrdemDeServicoService();

    public static void menuUpdateOS(Tecnico tecnico) {

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

        OrdemDeServico ordemDeServico = ((OrdemDeServico) ordemDeServicoService.buscarPorId(idOrdem));

        while(true)
        {

            while(!verifica)
            {

                System.out.println("\n                                                 \n");
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃             "+Ferramentas.ORANGE_DARK+"ATUALIZAR ORDEM DE SERVIÇO"+Ferramentas.AQUA_BLUE+"            ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃   "+Ferramentas.ORANGE_DARK+"EDITAR   ORDEM"+Ferramentas.AQUA_BLUE+"   ┃         ┃        "+Ferramentas.ORANGE_DARK+"ATUAL"+Ferramentas.AQUA_BLUE+"       ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+Ferramentas.AQUA_BLUE+"1 - Status"+Ferramentas.AQUA_BLUE+"        ┃         ┃ Status: " + ordemDeServico.getStatusDaOrdem());  // ok
                System.out.println("┃  \uD83D\uDD12 "+Ferramentas.ORANGE_DARK+"- Descrição"+Ferramentas.AQUA_BLUE+"     ┃         ┃ Descrição: " + ordemDeServico.getDescricao()); //ok
                System.out.println("┃  \uD83D\uDD12 "+Ferramentas.ORANGE_DARK+"- Maquina"+Ferramentas.AQUA_BLUE+"       ┃         ┃ Maquina: " + ordemDeServico.getIdMaquina());  //ok - mas só pelo ID
                System.out.println("┃  \uD83D\uDD12 "+Ferramentas.ORANGE_DARK+"- Tecnico"+Ferramentas.AQUA_BLUE+"       ┃         ┃ Técnico: " + ordemDeServico.getIdTecnico());   //ok
                System.out.println("┃  \uD83D\uDD12 "+Ferramentas.ORANGE_DARK+"- Valor"+Ferramentas.AQUA_BLUE+"         ┃         ┃ Valor: " + ordemDeServico.getValorDaOrdemDeServico()); //ok
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"6 - Sair do Menu"+Ferramentas.AQUA_BLUE+"  ┃         ┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃ ➤ Escolha:  ");

                try
                {
                    UpdateOs = Ferramentas.lInteiro();
                    verifica = true;
                } catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }
            //                    REINICIA A VARIÁVEL DE VERIFICAÇÃO                    //
            verifica = false;

            switch(UpdateOs)
            {

                case 1 -> {
                    StatusOS statusOs = MenuAlteraTecnico.MenuSetStatusOrdemDeServico();
                    ordemDeServico.setStatusDaOrdem(statusOs);
                    ordemDeServicoService.atualizar(statusOs);
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
*/