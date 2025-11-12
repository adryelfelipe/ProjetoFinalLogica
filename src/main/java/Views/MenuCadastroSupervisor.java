package Views;

import Dominio.OrdemDeServico.ObjetosDeValor.Descricao;
import Dominio.OrdemDeServico.ObjetosDeValor.ValorOS;
import Dominio.OrdemDeServico.OrdemDeServico;
import Dominio.Funcionario.Supervisor.Supervisor;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Util.Ferramentas;

public class MenuCadastroSupervisor
{
    // -- Atributos -- //
    public static void menuCadastroOrdem(Supervisor supervisor) {
        // Garantia de inicialização
        long idTecnico = 0;
        long idMaquina = 0;

        // Menu de cadastro
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃    CADASTRO ORDEM DE SERVIÇO   ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        try{
            idTecnico = MenuSetOrdemDeServico.SetIdTecnico();
            Ferramentas.limpaTerminal();
            idMaquina = MenuSetMaquina.SetIdMaquina();
        } catch (IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }
        Ferramentas.limpaTerminal();
        String descricao = MenuSetOrdemDeServico.SetDescricao();
        Ferramentas.limpaTerminal();
        double valorOS = MenuSetOrdemDeServico.SetValorOS();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        try {
            //OrdemDeServico ordemServico = new OrdemDeServico(idTecnico, supervisor.getId(), idMaquina,StatusOS.EM_ANDAMENTO, descricao, valorOS);
            //ordemDeServicoService.inserirOrdemDeServico(supervisor, ordemServico);
            Ferramentas.limpaTerminal();
            System.out.println("MÁQUINA CADASTRADO COM SUCESSO!");
            Ferramentas.Delay(800);
        } catch (IllegalArgumentException | IllegalStateException e) {
            Ferramentas.mensagemErro(e.getMessage());
        }
    }
}
