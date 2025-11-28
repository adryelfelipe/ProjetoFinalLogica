package Views.Funcionario.Gerente;

import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcRequest;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.OcorrenciaResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Util.Ferramentas;
import Views.Sistema.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MenuRelatorio {
    public static void menuRelatorio(long idGerente, NivelAcesso nivelAcesso) {

        while(true){
            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                       "+Ferramentas.ORANGE_DARK+"RELATÓRIOS"+Ferramentas.AQUA_BLUE+"                       ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Visualizar Ordens de Serviço"+Ferramentas.AQUA_BLUE+"                      ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Visualizar Ocorrências"+Ferramentas.AQUA_BLUE+"                            ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Retornar"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

            try {
                int opcao = Ferramentas.lInteiro();

                switch (opcao) {
                    case 1 -> visualizarOs(idGerente, nivelAcesso);
                    case 2 -> visualizarOc(idGerente, nivelAcesso);
                    case 3 -> {
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }

            Ferramentas.limpaTerminal();
        }
    }

    public static void visualizarOs(long idGerente, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarGerenteRequest = new FuncionarioPorIdRequest(idGerente);
        GerentePorIdResponse responseGerente = Main.gerenteController.buscarPorId(nivelAcesso, buscarGerenteRequest);

        // Pedido e resposta para listar ordens de servico
        ListarOsRequest listarOsRequest = new ListarOsRequest(idGerente, responseGerente.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOsResponse listarOsResponse = Main.osController.listarOsDepartamento(nivelAcesso, listarOsRequest);

        if(!listarOsResponse.status()) {
            Ferramentas.mensagemErro(listarOsResponse.mensagem());
            return;
        }

        if(listarOsResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA ORDEM DE SERVIÇO REGISTRADO NO SISTEMA");
            return;
        }

        // Menu
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃              "+Ferramentas.ORANGE_DARK+"VISUALIZAR ORDENS DE SERVIÇO"+Ferramentas.AQUA_BLUE+"              ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ordem de Serviço: "+Ferramentas.AQUA_BLUE+"%-33s┃%n", os.idOs());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status: "+Ferramentas.AQUA_BLUE+"%-46s┃%n", os.statusOs());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Descrição: "+Ferramentas.AQUA_BLUE+"%-43s┃%n", os.descricao().getDescricao());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Valor: "+Ferramentas.AQUA_BLUE+"%-47s┃%n", os.valorOs().getValorOS());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━┓    ┏━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃        "+Ferramentas.ORANGE_DARK+"TÉCNICO"+Ferramentas.AQUA_BLUE+"        ┃    ┃        "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"        ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━┃    ┃━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf ("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-18s┃    ┃ "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-18s┃ ┃%n", os.idTecnico(), os.idMaquina());
            System.out.printf ("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-16s┃    ┃ "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-16s┃ ┃%n", os.nomeTecnico().getNome(), os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━┛    ┗━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Tipo da Ordem de Serviço: "+Ferramentas.AQUA_BLUE+"%-28s┃%n", os.tipoOs().name());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("                                                          ");
            System.out.println("                                                          ");
        }

        System.out.print(Ferramentas.AQUA_BLUE+"┃  APERTE "+Ferramentas.ORANGE_DARK+"ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR: "); //  'ENTER' EM LARANJINHA
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }

    public static void visualizarOc(long idGerente, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarGerenteRequest = new FuncionarioPorIdRequest(idGerente);
        GerentePorIdResponse responseGerente = Main.gerenteController.buscarPorId(nivelAcesso, buscarGerenteRequest);

        // Pedido e resposta para listar ocorrências
        ListarOcRequest listarOcRequest = new ListarOcRequest(responseGerente.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOcResponse listarOcResponse = Main.ocController.listarOcDepartamento(nivelAcesso, listarOcRequest);

        if(!listarOcResponse.status()) {
            Ferramentas.mensagemErro(listarOcResponse.mensagem());
            return;
        }

        if(listarOcResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA OCORRÊNCIA REGISTRADA NO SISTEMA!");
            return;
        }
        // Menu
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                  "+Ferramentas.ORANGE_DARK+"TODAS AS OCORRÊNCIAS"+Ferramentas.AQUA_BLUE+"                  ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(); // pula linha

        for(OcorrenciaResponse oc : listarOcResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ocorrência: "+Ferramentas.AQUA_BLUE+"%-39s┃%n", oc.idOcorrencia());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status: "+Ferramentas.AQUA_BLUE+"%-46s┃%n", oc.statusOc());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-47s┃ ┃%n", oc.idMaquina() );
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-45s┃ ┃%n", oc.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Filtrar por supervisor"+Ferramentas.AQUA_BLUE+"                            ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Filtrar por status"+Ferramentas.AQUA_BLUE+"                                ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Retornar"+Ferramentas.AQUA_BLUE+"                                          ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        try {
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");
            int op = Ferramentas.lInteiro();

            switch(op) {
                case 1 -> menuFiltroSup(listarOcResponse.listaResponse(), responseGerente.listaDepartamentos().getListaDepartamentos().getFirst());
                case 2 -> menuFiltroStatus(listarOcResponse.listaResponse());
                case 3 -> {
                    Ferramentas.limpaTerminal();
                    return;
                }
            }
        } catch (InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        Ferramentas.limpaTerminal();
    }

    public static void menuFiltroDep(List<OcorrenciaResponse> ocorrenciaResponse) {
        Ferramentas.limpaTerminal();
        boolean verifica = false;

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Mecânica"+Ferramentas.AQUA_BLUE+"                                          ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Elétrica"+Ferramentas.AQUA_BLUE+"                                          ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        try {
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");
            int op = Ferramentas.lInteiro();

            switch(op) {
                case 1 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.departamento() == Departamento.MECANICA) {
                            verifica = true;
                            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ocorrência: "+Ferramentas.AQUA_BLUE+"%-39s┃%n", oc.idOcorrencia());
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status: "+Ferramentas.AQUA_BLUE+"%-46s┃%n", oc.statusOc());
                            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
                            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
                            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-47s┃ ┃%n", oc.idMaquina());
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-45s┃ ┃%n", oc.nomeMaquina().getNome());
                            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA OCORRÊNCIA COM ESSE DEPARTAMENTO");
                        return;
                    }
                }

                case 2 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.departamento() == Departamento.ELETRICA) {
                            verifica = true;
                            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ocorrência: "+Ferramentas.AQUA_BLUE+"%-39s┃%n", oc.idOcorrencia());
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status: "+Ferramentas.AQUA_BLUE+"%-46s┃%n", oc.statusOc());
                            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
                            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
                            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-47s┃ ┃%n", oc.idMaquina());
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-45s┃ ┃%n", oc.nomeMaquina().getNome());
                            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println("                                                          "); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA OCORRÊNCIA COM ESSE DEPARTAMENTO");
                        return;
                    }
                }
            }
        } catch (InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        System.out.println(Ferramentas.AQUA_BLUE+"┃  APERTE "+Ferramentas.ORANGE_DARK+"ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }

    public static void menuFiltroStatus(List<OcorrenciaResponse> ocorrenciaResponse) {
        Ferramentas.limpaTerminal();
        boolean verifica = false;
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - ABERTA"+Ferramentas.AQUA_BLUE+"                                            ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - EM ANDAMENTO"+Ferramentas.AQUA_BLUE+"                                      ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - FECHADA"+Ferramentas.AQUA_BLUE+"                                           ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");
        try {
            int op = Ferramentas.lInteiro();
            Ferramentas.limpaTerminal();
            switch(op) {
                case 1 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.statusOc() == StatusOc.ABERTA) {
                            verifica = true;
                            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ocorrência:"+Ferramentas.AQUA_BLUE+" %-39s┃%n", oc.idOcorrencia());
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status:"+Ferramentas.AQUA_BLUE+" %-46s┃%n", oc.statusOc());
                            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
                            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
                            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃ ┃%n", oc.idMaquina());
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃ ┃%n", oc.nomeMaquina().getNome());
                            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println("                                                          ");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA OCORRÊNCIA COM ESSE STATUS");
                        return;
                    }
                }

                case 2 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.statusOc() == StatusOc.EM_ANDAMENTO) {
                            verifica = true;
                            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ocorrência:"+Ferramentas.AQUA_BLUE+" %-39s┃%n", oc.idOcorrencia());
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status:"+Ferramentas.AQUA_BLUE+" %-46s┃%n", oc.statusOc());
                            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
                            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
                            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", oc.idMaquina());
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃%n", oc.nomeMaquina().getNome());
                            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println("                                                          ");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA OCORRÊNCIA COM ESSE STATUS");
                        return;
                    }
                }

                case 3 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.statusOc() == StatusOc.FECHADA) {
                            verifica = true;
                            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ocorrência:"+Ferramentas.AQUA_BLUE+" %-39s┃%n", oc.idOcorrencia());
                            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status:"+Ferramentas.AQUA_BLUE+" %-46s┃%n", oc.statusOc());
                            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
                            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
                            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", oc.idMaquina());
                            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃%n", oc.nomeMaquina().getNome());
                            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
                            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                            System.out.println("                                                          ");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA OCORRÊNCIA COM ESSE STATUS");
                        return;
                    }
                }
            }
        } catch (InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        System.out.println(Ferramentas.AQUA_BLUE+"┃  APERTE "+Ferramentas.ORANGE_DARK+"ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }

    public static void menuFiltroSup(List<OcorrenciaResponse> ocorrenciaResponse, Departamento departamentog) {
        Ferramentas.limpaTerminal();
        ListaFuncionariosResponse listaFuncionarios = Main.funcionarioController.listaFuncionariosParaGerente(NivelAcesso.GERENTE);
        Departamento departamento = null;
        List<FuncionarioResponse> encontrados = new ArrayList<>();
        System.out.print("┃ ➤ Digite o nome do supervisor: ");
        String nome = Ferramentas.lString();

        for(FuncionarioResponse func : listaFuncionarios.listaFuncionarios()) {
            if(func.nivelAcesso() == NivelAcesso.SUPERVISOR && func.nome().getNome().toLowerCase().contains(nome.toLowerCase()) && func.departamento() == departamentog) {
                encontrados.add(func);
            }
        }

        if(encontrados.isEmpty()) {
            Ferramentas.mensagemErro("┃  O FUNCIONARIO INFORMADO NÃO FOI ENCONTRADO");
            return;
        }

        int cont = 1;
        Ferramentas.limpaTerminal();
        System.out.println(Ferramentas.AQUA_BLUE+"┃  FORAM ENCONTRADOS " + Ferramentas.BOLD+Ferramentas.ORANGE_DARK + encontrados.size() + Ferramentas.RESET+Ferramentas.AQUA_BLUE + " SUPERVISORES: ");
        for(FuncionarioResponse response : encontrados)
        {
            System.out.println("┃  " + cont + " - " + response.nome().getNome());
            cont ++;
        }
        System.out.println();
        System.out.print("┃ ➤ Escolha: ");
        try{
            int op = Ferramentas.lInteiro();

            if(op < 1 || op > encontrados.size()) {
                Ferramentas.mensagemErro("┃  OPÇÃO INVÁLIDA");
                return;
            }

            departamento = encontrados.get(op - 1).departamento();
            boolean verifica = false;

            Ferramentas.limpaTerminal();
            for(OcorrenciaResponse oc : ocorrenciaResponse) {
                if(oc.departamento() == departamento) {
                    System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                    System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID Ocorrência:"+Ferramentas.AQUA_BLUE+" %-39s┃%n", oc.idOcorrencia());
                    System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status:"+Ferramentas.AQUA_BLUE+" %-46s┃%n", oc.statusOc());
                    System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
                    System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
                    System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
                    System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃ ┃%n", oc.idMaquina());
                    System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃ ┃%n", oc.nomeMaquina().getNome());
                    System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
                    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                    System.out.println("                                                          "); // pula linha
                    verifica = true;
                }
            }

            if(!verifica) {
                Ferramentas.mensagemErro("┃  NÃO FOI POSSÍVEL ENCONTRAR NENHUMA OCORRÊNCIA VINCULADA A ESTE SUPERVISOR");
                return;
            }
        } catch (InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        System.out.println(Ferramentas.AQUA_BLUE+"┃  APERTE "+Ferramentas.ORANGE_DARK+"ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }
}
