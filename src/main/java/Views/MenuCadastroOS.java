package Views;

import Models.GerenteModel;
import Models.MaquinaModel;
import Models.OrdemDeServicoModel;
import Models.SupervisorModel;
import ProjetoBase.OrdemDeServicoService;
import Repositories.OrdemDeServicoDAO;
import Util.Ferramentas;

public class MenuCadastroOS {
    private static final OrdemDeServicoService ordemServicoService = new OrdemDeServicoService();

    public static void menuCadastroOrdem(SupervisorModel supervisor) {
        // Garantia de inicialização
        long idTecnico = 0;
        long idMaquina = 0;

        // Menu de cadastro
        System.out.println("================================");
        System.out.println("|  CADASTRO  ORDEM DE SERVIÇO  |");
        System.out.println("================================\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        try{
            idTecnico = MenuSetOrdemDeServico.SetIdTecnico();
            Ferramentas.limpaTerminal();
            idMaquina = MenuSetOrdemDeServico.SetIdMaquina();
        } catch (IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }
        Ferramentas.limpaTerminal();
        String descricao = MenuSetOrdemDeServico.SetDescricao();
        Ferramentas.limpaTerminal();
        double valorOrdemServico = MenuSetOrdemDeServico.SetValorOS();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            OrdemDeServicoModel ordemServico = new OrdemDeServicoModel(idTecnico, idMaquina,1, descricao, valorOrdemServico);
            ordemServicoService.inserirOrdemDeServico(supervisor, ordemServico);
            Ferramentas.limpaTerminal();
            System.out.println("MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}