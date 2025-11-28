package Views.Funcionario.Supervisor;

import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId.SupervisorPorIdResponse;
import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdRequest;
import Aplicacao.Ocorrencia.Dtos.Buscar.BuscarOcPorIdResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcRequest;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.OcorrenciaResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Sistema.Main;

import java.util.InputMismatchException;

public class MenuRelatorioSupervisor {
    public static void menuRelatorio(long idSupervisor, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        while(true){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                       RELATÓRIOS                       ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  1 - Visualizar Ordem de Serviço                       ┃");
            System.out.println("┃  2 - Visualizar Ocorrências                            ┃");
            System.out.println("┃  3 - Retornar                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcao = Ferramentas.lInteiro();

                switch (opcao) {
                    case 1 -> visualizarOs(idSupervisor, nivelAcesso);
                    case 2 -> visualizarOc(idSupervisor, nivelAcesso);
                    case 3 -> {
                        Ferramentas.limpaTerminal();
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }

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

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf ("┃  ID Ordem Serviço: %-36s┃%n", os.idOs());
            System.out.printf ("┃  Status: %-46s┃%n", os.statusOs());
            System.out.printf ("┃  Descrição: %-43s┃%n", os.descricao().getDescricao());
            System.out.printf ("┃  Valor: %-47s┃%n", os.valorOs().getValorOS());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━┓    ┏━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃        TÉCNICO        ┃    ┃        MÁQUINA        ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━┃    ┃━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf ("┃ ┃ ID: %-18s┃    ┃ ID: %-18s┃ ┃", os.idTecnico(), os.idMaquina());
            System.out.printf ("\n┃ ┃ Nome: %-16s┃    ┃ Nome: %-16s┃ ┃", os.nomeTecnico().getNome(), os.nomeMaquina().getNome());
            System.out.println("\n┃ ┗━━━━━━━━━━━━━━━━━━━━━━━┛    ┗━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf ("┃  Tipo da Ordem de Serviço: %-28s┃%n", os.tipoOs());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("                                                          "); // pula linha
        }

        System.out.println(); // pula linha

        System.out.print("┃  APERTE ENTER PARA CONTINUAR: ");
        Ferramentas.lString();

        Ferramentas.limpaTerminal();
    }

    public static void visualizarOc(long idSupervisor, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarGerenteRequest = new FuncionarioPorIdRequest(idSupervisor);
        SupervisorPorIdResponse responseGerente = Main.supervisorController.buscarPorId(buscarGerenteRequest);

        // Pedido e resposta para listar ocorrências
        ListarOcRequest listarOcRequest = new ListarOcRequest(responseGerente.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOcResponse listarOcResponse = Main.ocController.listarOcDepartamento(nivelAcesso, listarOcRequest);

        if(!listarOcResponse.status()) {
            Ferramentas.mensagemErro(listarOcResponse.mensagem());
            return;
        }

        if(listarOcResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA OCORRÊNCIA REGISTRADA NO SISTEMA");
            return;
        }
        // Menu
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  TODAS AS OCORRÊNCIAS                  ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");


        System.out.println(); // pula linha

        for(OcorrenciaResponse oc : listarOcResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf ("┃  ID Ocorrencia: %-39s┃%n", oc.idOcorrencia());
            System.out.printf ("┃  Status: %-46s┃%n", oc.statusOc());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       MÁQUINA                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf ("┃ ┃ ID: %-47s┃ ┃", oc.idMaquina());
            System.out.printf ("\n┃ ┃ Nome: %-45s┃ ┃", oc.nomeMaquina().getNome());
            System.out.println("\n┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        boolean verifica = false;
        while(!verifica) {
            try {
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  1 - Criar uma ordem de serviço preditiva              ┃");
                System.out.println("┃  2 - Retornar                                          ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.print("┃ ➤ Escolha: ");
                int op = Ferramentas.lInteiro();
                verifica = true;

                switch(op) {
                    case 1 -> {
                        System.out.println();
                        System.out.print("┃  Escolha o ID da ocorrência: ");
                        try {
                            long idOc = Ferramentas.lInteiro();
                            BuscarOcPorIdRequest request = new BuscarOcPorIdRequest(idOc);
                            BuscarOcPorIdResponse response = Main.ocController.buscarOcPorId(nivelAcesso, request);

                            if(response.status()) {
                                Ferramentas.limpaTerminal();
                                MenuCadastroSupervisor.menuCadastroOrdemPreditiva(idSupervisor, nivelAcesso, response);
                            } else {
                                Ferramentas.mensagemErro(response.mensagem());
                                return;
                            }
                        } catch (InputMismatchException e) {
                            Ferramentas.menuDefault();
                        }
                    }

                    case 2 -> {
                        Ferramentas.limpaTerminal();
                        return;
                    }
                }
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }

        Ferramentas.limpaTerminal();
    }
}
