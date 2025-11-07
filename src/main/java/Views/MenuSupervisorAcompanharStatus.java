package Views;

import Models.AdminModel;
import Models.OrdemDeServicoModel;
import Models.SupervisorModel;
import ProjetoBase.*;
import Util.Ferramentas;

    public class MenuSupervisorAcompanharStatus{

    private static final UsuarioService usuarioService = new UsuarioService();
    private static final SupervisorService supervisorService = new SupervisorService();
    private static final OrdemDeServicoService ordemService = new OrdemDeServicoService();

        public static void acompanharStatus(SupervisorModel supervisor) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃    ACOMPANHAR STATUS DE SO     ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            try {
                UsuarioValidator.temNivelAcesso2(supervisor);
                long idDaOS = MenuEscolhaId.escolhaIdUpdate();

               OrdemDeServicoModel osEncontrada = ordemService.visualizarDetalhesDaOS(supervisor, idDaOS);

                System.out.println("\n--- Detalhes da OS #" + osEncontrada.getIdOrdemDeServico() + " ---");
                System.out.println("Status: " + osEncontrada.getStatusDaOrdem());
                System.out.println("Descrição: " + osEncontrada.getDescricao());

            } catch (RuntimeException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
}
