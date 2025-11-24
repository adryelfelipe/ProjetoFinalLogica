package Views;

import Models.OrdemDeServico;
import Models.Tecnico;
import Models.Enumeracoes.Especialidade;
import Service.OrdemDeServicoService;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuUpdateTecnico
{

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

        OrdemDeServico ordemDeServico = ((OrdemDeServico) ordemDeServicoService.findById(idOrdem));

        while(true)
        {

            while(!verifica)
            {

                System.out.println("\n                                                 \n");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                    ATUALIZAR OS                   ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                     ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓         ┏━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃   EDITAR   ORDEM   ┃         ┃        ATUAL       ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃         ┃━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃  1 - Status        ┃         ┃ Status: " + ordemDeServico.getStatusDaOrdem());
                System.out.println("┃  2 - Descrição     ┃         ┃ Descrição: " + ordemDeServico.getDescricao());
                System.out.println("┃  3 - Maquina       ┃         ┃ Maquina: " + ordemDeServico.getIdMaquina());
                System.out.println("┃  5 - Tecnico       ┃         ┃ Técnico: " + ordemDeServico.getIdTecnico());
                System.out.println("┃  6 - Valor         ┃         ┃ Valor: " + ordemDeServico.getValorDaOrdemDeServico());
                System.out.println("┃  7 - Sair do Menu  ┃         ┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃  Escolha:  ");

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

                case 1 -> {
                    String nome = MenuSetUsuario.MenuSetNome();
                    tecnico.setNome(nome);
                    ordemDeServicoService.atualizarTecnico_OS(nome);
                }

                case 2 -> {
                    String cpf = MenuSetUsuario.MenuSetCpf();
                    ordemDeServicoService.updateCpfUsuario(cpf);
                    tecnico.setCpf(cpf);
                }

                case 3 -> {
                    String senha = MenuSetUsuario.MenuSetSenha();
                    ordemDeServicoService.updateSenhaUsuario(senha);
                    tecnico.setSenha(senha);
                }
                case 4 -> {
                    Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();
                    ordemDeServicoService.updateEspecialidade(especialidade);
                    tecnico.setEspecialidade(especialidade);
                }
                case 5 ->
                {
                    return;
                }
                default -> Ferramentas.menuDefault();
            }


        }
    }


}
