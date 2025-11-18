package Views.Funcionario.Supervisor;

import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Cadastro.CadastroOsResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Dominio.OrdemDeServico.Enumeracoes.TipoOS;
import Util.Ferramentas;
import Views.Maquina.MenuSetMaquina;
import Views.OrdemDeServico.MenuSetOrdemDeServico;
import Views.Sistema.Main;

public class MenuCadastroSupervisor
{
    // -- Atributos -- //
    public static void menuCadastroOrdem(long idSupervisor, NivelAcesso nivelAcesso) {
        // Menu de cadastro
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃    CADASTRO ORDEM DE SERVIÇO   ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\n");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        long idTecnico = MenuSetOrdemDeServico.SetIdTecnico();
        Ferramentas.limpaTerminal();
        long idMaquina = MenuSetMaquina.SetIdMaquina();
        Ferramentas.limpaTerminal();
        String descricao = MenuSetOrdemDeServico.SetDescricao();
        Ferramentas.limpaTerminal();
        double valorOS = MenuSetOrdemDeServico.SetValorOS();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        System.out.println("PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Ordem de Serviço -- //
        CadastroOsRequest request = new CadastroOsRequest(idTecnico, idSupervisor, idMaquina, StatusOS.ABERTA, descricao, valorOS, TipoOS.CORRETIVA);
        CadastroOsResponse response = Main.osController.salvar(nivelAcesso, request);

        if(response.status()) {
            Ferramentas.mensagemSucesso(response.mensagem());
        } else {
            Ferramentas.mensagemErro(response.mensagem());
        }

        Ferramentas.limpaTerminal();
    }
}
