package Views.Funcionario.Supervisor;

import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdResponse;
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
    public static void menuCadastroOrdemCorretiva(long idSupervisor, NivelAcesso nivelAcesso) {
        // Menu de cadastro
        Ferramentas.limpaTerminal();
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃               CADASTRO ORDEM DE SERVIÇO                ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

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
        System.out.print("┃  PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Ordem de Serviço -- //
        CadastroOsRequest request = new CadastroOsRequest(idTecnico, idSupervisor, idMaquina, StatusOS.ABERTA, descricao, valorOS, TipoOS.CORRETIVA, null);
        CadastroOsResponse response = Main.osController.salvar(nivelAcesso, request);

        if(response.status()) {
            Ferramentas.mensagemSucesso(response.mensagem());
        } else {
            Ferramentas.mensagemErro(response.mensagem());
        }

        Ferramentas.limpaTerminal();
    }

    public static void menuCadastroOrdemPreditiva(long idSupervisor, NivelAcesso nivelAcesso, BuscarOcPorIdResponse response) {
        // Menu de cadastro
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃               CADASTRO ORDEM DE SERVIÇO                ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        // ----- Atribuição de caracteríscticas de uma Máquina ----- //
        long idTecnico = MenuSetOrdemDeServico.SetIdTecnico();
        Ferramentas.limpaTerminal();
        String descricao = MenuSetOrdemDeServico.SetDescricao();
        Ferramentas.limpaTerminal();
        double valorOS = MenuSetOrdemDeServico.SetValorOS();
        Ferramentas.limpaTerminal();

        // -- Criação do objeto e inserção no banco de dados -- //
        System.out.print("┃  PROCESSANDO DADOS...");
        Ferramentas.Delay(1000);

        // -- Gerando request para cadastro de Ordem de Serviço -- //
        CadastroOsRequest requestPreditiva = new CadastroOsRequest(idTecnico, idSupervisor, response.idMaquina(), StatusOS.ABERTA, descricao, valorOS, TipoOS.PREDITIVA, response.idOcorrencia());
        CadastroOsResponse responsePreditiva = Main.osController.salvar(nivelAcesso, requestPreditiva);

        if(responsePreditiva.status()) {
            Ferramentas.mensagemSucesso(responsePreditiva.mensagem());
        } else {
            Ferramentas.mensagemErro(responsePreditiva.mensagem());
        }

        Ferramentas.limpaTerminal();
    }
}
