package Views.Funcionario.Tecnico;

import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.BuscarPorId.TecnicoPorIdResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Util.Ferramentas;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;

public class MenuTecnicoOs {
    public static void ordensServicos(long idTecnico, NivelAcesso nivelAcesso) {

        while (true) {
            Ferramentas.limpaTerminal();

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃          MENU TÉCNICO - OS           ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                      ┃");
            System.out.println("┃  1 - Visualizar minhas OS's          ┃");
            System.out.println("┃  2 - Iniciar ordem de serviço        ┃");
            System.out.println("┃  3 - Finalizar ordem de serviço      ┃");
            System.out.println("┃  4 - Retornar                        ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcaoAdmin = Ferramentas.lInteiro();

                switch (opcaoAdmin) {
                    case 1 -> minhasOrdens(idTecnico, nivelAcesso);
                    //case 2 ->
                   // case 3 ->
                    case 4 -> {
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.menuDefault();
            }
        }
    }

    public static void minhasOrdens(long idTecnico, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarTecnicoRequest = new FuncionarioPorIdRequest(idTecnico);
        TecnicoPorIdResponse responseTecnico = Main.tecnicoController.buscarPorId(buscarTecnicoRequest);

        // Pedido e resposta para listar ordens de servico
        ListarOsRequest listarOsRequest = new ListarOsRequest(idTecnico, responseTecnico.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOsResponse listarOsResponse = Main.osController.listarOsTecnico(nivelAcesso, listarOsRequest);

        if(!listarOsResponse.status()) {
            Ferramentas.mensagemErro(listarOsResponse.mensagem());
            return;
        }

        if(listarOsResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("Não há ordens de serviço ativas no momento");
            return;
        }

        // Menu
        System.out.println("==============================");
        System.out.println("== MINHAS ORDENS DE SERVIÇO ==");
        System.out.println("==============================");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("ID OS: " + os.idOs());
            System.out.println("Status: " + os.statusOs());
            System.out.println("Descrição: " + os.descricao().getDescricao());
            System.out.println("Máquina -> ID: " + os.idMaquina() + " | Nome: " + os.nomeMaquina().getNome());
            System.out.println("--");
            System.out.println("--");
            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        System.out.print("Aperte enter para continuar: ");
        Ferramentas.lString();
    }

    public static void iniciarOrdem(long idTecnico, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarTecnicoRequest = new FuncionarioPorIdRequest(idTecnico);
        TecnicoPorIdResponse responseTecnico = Main.tecnicoController.buscarPorId(buscarTecnicoRequest);

        // Pedido e resposta para listar ordens de servico
        ListarOsRequest listarOsRequest = new ListarOsRequest(idTecnico, responseTecnico.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOsResponse listarOsResponse = Main.osController.listarOsTecnico(nivelAcesso, listarOsRequest);

        if(!listarOsResponse.status()) {
            Ferramentas.mensagemErro(listarOsResponse.mensagem());
            return;
        }

        if(listarOsResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("Não há ordens de serviço ativas no momento");
            return;
        }

        // Menu
        System.out.println("==============================");
        System.out.println("== INICIAR ORDEM DE SERIVÇO ==");
        System.out.println("==============================");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            if(os.statusOs() == StatusOS.ABERTA) {
                System.out.println("ID OS: " + os.idOs());
                System.out.println("Status: " + os.statusOs());
                System.out.println("Descrição: " + os.descricao().getDescricao());
                System.out.println("Máquina -> ID: " + os.idMaquina() + " | Nome: " + os.nomeMaquina().getNome());
                System.out.println("--");
                System.out.println("--");
                System.out.println(); // pula linha
            }
        }

        System.out.println(); // pula linha

        System.out.print("Aperte enter para continuar: ");
        long id = MenuEscolhaId.escolhaIdOs();
    }
}
