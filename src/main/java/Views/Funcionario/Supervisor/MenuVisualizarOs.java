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
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃               "+Ferramentas.ORANGE_DARK+"TODAS AS ORDENS DE SERVIÇO"+Ferramentas.AQUA_BLUE+"               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID OS:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", os.idOs());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status:"+Ferramentas.AQUA_BLUE+" %-46s┃%n", os.statusOs());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Descrição:"+Ferramentas.AQUA_BLUE+" %-43s┃%n", os.descricao().getDescricao());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Valor:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", os.valorOs().getValorOS());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━┓    ┏━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃        "+Ferramentas.ORANGE_DARK+"TÉCNICO"+Ferramentas.AQUA_BLUE+"        ┃    ┃        "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"        ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━┃    ┃━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃ ┃%n", os.idTecnico() + "┃    ┃ "+Ferramentas.ORANGE_DARK+"ID"+Ferramentas.AQUA_BLUE+" " + os.idMaquina());
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃ ┃%n", os.nomeTecnico().getNome() + "┃    ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" " + os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Tipo da OS:"+Ferramentas.AQUA_BLUE+" %-42s┃%n", os.tipoOs().name());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        System.out.print("┃  APERTE "+Ferramentas.ORANGE_DARK+"ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR: ");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }
}
