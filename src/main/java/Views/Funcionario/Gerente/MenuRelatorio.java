package Views.Funcionario.Gerente;

import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId.SupervisorPorIdResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcRequest;
import Aplicacao.Ocorrencia.Dtos.Listar.ListarOcResponse;
import Aplicacao.Ocorrencia.Dtos.Listar.OcorrenciaResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Ocorrencia.Enumeracoes.StatusOc;
import Dominio.Ocorrencia.Ocorrencia;
import Util.Ferramentas;
import Views.Sistema.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MenuRelatorio {
    public static void menuRelatorio(long idGerente, NivelAcesso nivelAcesso) {

        while(true){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃           RELATÓRIOS           ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃  1 - Visualizar OS's           ┃");
            System.out.println("┃  2 - Visualizar Ocorrências    ┃");
            System.out.println("┃  3 - Retornar                  ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                       RELATÓRIOS                       ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  1 - Criar Gerente                                     ┃");
            System.out.println("┃  2 - Atualizar Gerente                                 ┃");
            System.out.println("┃  3 - Remover Funcionários                              ┃");
            System.out.println("┃  4 - Retornar                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

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
            Ferramentas.mensagemErro("Não há nenhuma ordem de serviço registrada no sistema");
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
            Ferramentas.mensagemErro("Não há nenhuma ocorrência registrada no sistema");
            return;
        }
        // Menu
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃      TODAS AS OCORRÊNCIAS      ┃");
        System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");

        System.out.println(); // pula linha

        for(OcorrenciaResponse oc : listarOcResponse.listaResponse()) {
            System.out.println("ID OC: " + oc.idOcorrencia());
            System.out.println("Status: " + oc.statusOc());
            System.out.println("Máquina -> ID: " + oc.idMaquina() + " | Nome: " + oc.nomeMaquina().getNome());
            System.out.println("--");
            System.out.println("--");
            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        System.out.println("1 - Filtrar por supervisor");
        System.out.println("2 - Filtrar por status");
        System.out.println("3 - Retornar");
        try {
            System.out.print("Escolha: ");
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

        System.out.println("1 - Mecânica");
        System.out.println("2 - Elétrica");
        try {
            System.out.print("Escolha: ");
            int op = Ferramentas.lInteiro();

            switch(op) {
                case 1 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.departamento() == Departamento.MECANICA) {
                            verifica = true;
                            System.out.println("ID OC: " + oc.idOcorrencia());
                            System.out.println("Status: " + oc.statusOc());
                            System.out.println("Máquina -> ID: " + oc.idMaquina() + " | Nome: " + oc.nomeMaquina().getNome());
                            System.out.println("--");
                            System.out.println("--");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("Não há nenhuma ocorrência com esse departamento");
                        return;
                    }
                }

                case 2 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.departamento() == Departamento.ELETRICA) {
                            verifica = true;
                            System.out.println("ID OC: " + oc.idOcorrencia());
                            System.out.println("Status: " + oc.statusOc());
                            System.out.println("Máquina -> ID: " + oc.idMaquina() + " | Nome: " + oc.nomeMaquina().getNome());
                            System.out.println("--");
                            System.out.println("--");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("Não há nenhuma ocorrência com esse departamento");
                        return;
                    }
                }
            }
        } catch (InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        System.out.println("Aperte enter para continuar");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }

    public static void menuFiltroStatus(List<OcorrenciaResponse> ocorrenciaResponse) {
        Ferramentas.limpaTerminal();
        boolean verifica = false;
        System.out.println("1 - ABERTA");
        System.out.println("2 - EM ANDAMENTO");
        System.out.println("3 - FECHADA");
        System.out.print("Escolha: ");
        try {
            int op = Ferramentas.lInteiro();
            Ferramentas.limpaTerminal();
            switch(op) {
                case 1 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.statusOc() == StatusOc.ABERTA) {
                            verifica = true;
                            System.out.println("ID OC: " + oc.idOcorrencia());
                            System.out.println("Status: " + oc.statusOc());
                            System.out.println("Máquina -> ID: " + oc.idMaquina() + " | Nome: " + oc.nomeMaquina().getNome());
                            System.out.println("--");
                            System.out.println("--");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("Não há nenhuma ocorrência com esse status");
                        return;
                    }
                }

                case 2 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.statusOc() == StatusOc.EM_ANDAMENTO) {
                            verifica = true;
                            System.out.println("ID OC: " + oc.idOcorrencia());
                            System.out.println("Status: " + oc.statusOc());
                            System.out.println("Máquina -> ID: " + oc.idMaquina() + " | Nome: " + oc.nomeMaquina().getNome());
                            System.out.println("--");
                            System.out.println("--");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("Não há nenhuma ocorrência com esse status");
                        return;
                    }
                }

                case 3 -> {
                    for(OcorrenciaResponse oc : ocorrenciaResponse) {
                        if(oc.statusOc() == StatusOc.FECHADA) {
                            verifica = true;
                            System.out.println("ID OC: " + oc.idOcorrencia());
                            System.out.println("Status: " + oc.statusOc());
                            System.out.println("Máquina -> ID: " + oc.idMaquina() + " | Nome: " + oc.nomeMaquina().getNome());
                            System.out.println("--");
                            System.out.println("--");
                            System.out.println(); // pula linha
                        }
                    }

                    if(!verifica) {
                        Ferramentas.mensagemErro("Não há nenhuma ocorrência com esse status");
                        return;
                    }
                }
            }
        } catch (InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        System.out.println("Aperte enter para continuar");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }

    public static void menuFiltroSup(List<OcorrenciaResponse> ocorrenciaResponse, Departamento departamentog) {
        Ferramentas.limpaTerminal();
        ListaFuncionariosResponse listaFuncionarios = Main.funcionarioController.listaFuncionariosParaGerente(NivelAcesso.GERENTE);
        Departamento departamento = null;
        List<FuncionarioResponse> encontrados = new ArrayList<>();
        System.out.print("Digite o nome do supervisor: ");
        String nome = Ferramentas.lString();

        for(FuncionarioResponse func : listaFuncionarios.listaFuncionarios()) {
            if(func.nivelAcesso() == NivelAcesso.SUPERVISOR && func.nome().getNome().toLowerCase().contains(nome.toLowerCase()) && func.departamento() == departamentog) {
                encontrados.add(func);
            }
        }

        if(encontrados.isEmpty()) {
            Ferramentas.mensagemErro("O funcionário informado não foi encontrado");
            return;
        }

        int cont = 1;
        Ferramentas.limpaTerminal();
        System.out.println("Foram encontrados " + encontrados.size() + " supervisores: ");
        for(FuncionarioResponse response : encontrados) {
            System.out.println(cont + " - " + response.nome().getNome());
            cont ++;
        }
        System.out.println();
        System.out.print("Escolha: ");
        try{
            int op = Ferramentas.lInteiro();

            if(op < 1 || op > encontrados.size()) {
                Ferramentas.mensagemErro("Opção inválida");
                return;
            }

            departamento = encontrados.get(op - 1).departamento();
            boolean verifica = false;

            Ferramentas.limpaTerminal();
            for(OcorrenciaResponse oc : ocorrenciaResponse) {
                if(oc.departamento() == departamento) {
                    System.out.println("ID OC: " + oc.idOcorrencia());
                    System.out.println("Status: " + oc.statusOc());
                    System.out.println("Máquina -> ID: " + oc.idMaquina() + " | Nome: " + oc.nomeMaquina().getNome());
                    System.out.println("--");
                    System.out.println("--");
                    System.out.println(); // pula linha
                    verifica = true;
                }
            }

            if(!verifica) {
                Ferramentas.mensagemErro("Não foi possível encontrar nenhuma ocorrência vinculada a este supervisor");
                return;
            }
        } catch (InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        System.out.println("Aperte enter para continuar");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }
}
