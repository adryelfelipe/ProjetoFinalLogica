package Views.Funcionario.Supervisor;

import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId.SupervisorPorIdResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Sistema.Main;

import java.sql.SQLOutput;

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
            Ferramentas.mensagemErro("┃  NÃO HÁ ORDENS DE SERVIÇO ATIVAS NO MOMENTO");
            return;
        }

        // Menu
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃               TODAS AS ORDENS DE SERVIÇO               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.printf("┃  ID OS: %-47s┃%n", os.idOs());
            System.out.printf("┃  Status: %-46s┃%n", os.statusOs());
            System.out.printf("┃  Descrição: %-43s┃%n", os.descricao().getDescricao());
            System.out.printf("┃  Valor: %-47s┃%n", os.valorOs().getValorOS());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━┓    ┏━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃        TÉCNICO        ┃    ┃        MÁQUINA        ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━┃    ┃━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ ID: %-47s┃ ┃%n", os.idTecnico() + "┃    ┃ ID" + os.idMaquina());
            System.out.printf("┃ ┃ Nome: %-45s┃ ┃%n", os.nomeTecnico().getNome() + "┃    ┃ Nome: " + os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  Tipo da OS: %-42s┃%n", os.tipoOs().name());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        System.out.print("┃  APERTE ENTER PARA CONTINUAR: ");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }
}
