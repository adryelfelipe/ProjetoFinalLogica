package Views;

import Models.Enumeracoes.Departamento;
import Models.OrdemDeServico;
import Models.Supervisor;
import Models.Enumeracoes.StatusOS;
import Service.MaquinaService;
import Service.OrdemDeServicoService;
import Util.Ferramentas;

public class MenuCadastroSupervisor
{
    // -- Atributos -- //
    private static final OrdemDeServicoService ordemDeServicoService = new OrdemDeServicoService();
    private static final MaquinaService maquinaService = new MaquinaService();

    public static void menuCadastroOrdem(Supervisor supervisor) {
        // Garantia de inicialização
        long idTecnico = 0;
        long idMaquina = 0;

        // Menu de cadastro
        System.out.println("|================================|");
        System.out.println("|    CADASTRO ORDEM DE SERVIÇO   |");
        System.out.println("|================================|\n");

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

        Departamento departamento = maquinaService.maquinaParaDepartamento(idMaquina);

        try {
            OrdemDeServico ordemServico =   new OrdemDeServico(idTecnico, idMaquina,StatusOS.EM_ANDAMENTO, descricao, valorOrdemServico, departamento);
            ordemDeServicoService.inserirOrdemDeServico(supervisor, ordemServico);
            Ferramentas.limpaTerminal();
            System.out.println("MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
