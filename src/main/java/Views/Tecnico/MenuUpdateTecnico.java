package Views.Tecnico;

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
{/*
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
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃             ATUALIZAR ORDEM DE SERVIÇO            ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃   EDITAR   ORDEM   ┃         ┃        ATUAL       ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃  1 - Status        ┃         ┃ Status: " + ordemDeServico.getStatusDaOrdem());  // ok
                System.out.println("┃  \uD83D\uDD12 - Descrição     ┃         ┃ Descrição: " + ordemDeServico.getDescricao()); //ok
                System.out.println("┃  \uD83D\uDD12 - Maquina       ┃         ┃ Maquina: " + ordemDeServico.getIdMaquina());  //ok - mas só pelo ID
                System.out.println("┃  \uD83D\uDD12 - Tecnico       ┃         ┃ Técnico: " + ordemDeServico.getIdTecnico());   //ok
                System.out.println("┃  \uD83D\uDD12 - Valor         ┃         ┃ Valor: " + ordemDeServico.getValorDaOrdemDeServico()); //ok
                System.out.println("┃  6 - Sair do Menu  ┃         ┗━━━━━━━━━━━━━━━━━━━━┛");
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

*/
}
