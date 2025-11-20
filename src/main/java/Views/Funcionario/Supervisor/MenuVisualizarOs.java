package Views.Funcionario.Supervisor;

import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId.SupervisorPorIdResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Sistema.Main;

public class MenuVisualizarOs {
    public static void visualizarOs(long idFuncionario, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarSupervisorRequest = new FuncionarioPorIdRequest(idFuncionario);
        SupervisorPorIdResponse responseSupervisor = Main.supervisorController.buscarPorId(buscarSupervisorRequest);

        // Pedido e resposta para listar ordens de servico
        ListarOsRequest listarOsRequest = new ListarOsRequest(idFuncionario, responseSupervisor.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOsResponse listarOsResponse = Main.osController.listarOsDepartamento(nivelAcesso, listarOsRequest);

        if(!listarOsResponse.status()) {
            Ferramentas.mensagemErro(listarOsResponse.mensagem());
            return;
        }

        if(listarOsResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("Não há ordens de serviço ativas no momento");
            return;
        }

        // Menu
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃   TODAS AS ORDENS DE SERVIÇO   ┃");
        System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("ID OS: " + os.idOs());
            System.out.println("Status: " + os.statusOs());
            System.out.println("Descrição: " + os.descricao().getDescricao());
            System.out.println("Valor: " + os.valorOs().getValorOS());
            System.out.println("Técnico -> ID: " + os.idTecnico() + " | Nome: " + os.nomeTecnico().getNome());
            System.out.println("Máquina -> ID: " + os.idMaquina() + " | Nome: " + os.nomeMaquina().getNome());
            System.out.println("Tipo da OS: " + os.tipoOs().name());
            System.out.println("--");
            System.out.println("--");
            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        System.out.print("Aperte enter para continuar: ");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }
}
