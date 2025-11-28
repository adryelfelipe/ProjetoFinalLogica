package Views.Funcionario.Tecnico;

import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Exceptions.Requests.BuscarPorIdNuloException;
import Aplicacao.Funcionario.Tecnico.Dtos.BuscarPorId.TecnicoPorIdResponse;
import Aplicacao.OrdemDeServico.Dtos.Atualizar.AtualizarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Atualizar.AtualizarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsRequest;
import Aplicacao.OrdemDeServico.Dtos.Listar.ListarOsResponse;
import Aplicacao.OrdemDeServico.Dtos.Listar.OrdemServicoResponse;
import Aplicacao.OrdemDeServico.Exceptions.Handler.IdOsNaoEncontradoException;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.OrdemDeServico.Enumeracoes.StatusOS;
import Util.Ferramentas;
import Views.Sistema.Main;

import java.util.InputMismatchException;

public class MenuTecnicoOs {
    public static void ordensServicos(long idTecnico, NivelAcesso nivelAcesso) {

        while (true) {
            Ferramentas.limpaTerminal();

            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                   MENU TÉCNICO - OS                    ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  1 - Visualizar minhas Ordens                          ┃");
            System.out.println("┃  2 - Iniciar ordem de serviço                          ┃");
            System.out.println("┃  3 - Finalizar ordem de serviço                        ┃");
            System.out.println("┃  4 - Retornar                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try {
                int opcaoAdmin = Ferramentas.lInteiro();

                switch (opcaoAdmin) {
                    case 1 -> minhasOrdens(idTecnico, nivelAcesso);
                    case 2 -> iniciarOrdem(idTecnico, nivelAcesso);
                    case 3 -> finalizarOrdem(idTecnico, nivelAcesso);
                    case 4 -> {
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

    public static void minhasOrdens(long idTecnico, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarTecnicoRequest = new FuncionarioPorIdRequest(idTecnico);
        TecnicoPorIdResponse responseTecnico = Main.tecnicoController.buscarPorId(buscarTecnicoRequest);

        // Pedido e resposta para listar ordens de servico
        ListarOsRequest listarOsRequest = new ListarOsRequest(idTecnico, responseTecnico.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOsResponse listarOsResponse = Main.osController.listarOsTecnicoAtivas(nivelAcesso, listarOsRequest);

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
        System.out.println("┃                MINHAS ORDENS DE SERVIÇO                ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse())
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  ID OS: %-47s┃%n", os.idOs());
            System.out.printf("┃  Status: %-46s┃%n", os.statusOs());
            System.out.printf("┃  Descrição: %-43s┃%n", os.descricao().getDescricao());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       MÁQUINA                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ ID: %-47s┃ ┃%n", os.idMaquina());
            System.out.printf("┃ ┃ Nome: %-45s┃ ┃%n", os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  Tipo da OS: %-42s┃%n", os.tipoOs());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("                                                          "); // pula linha
        }

        System.out.println(); // pula linha

        System.out.print("┃  APERTE ENTER PARA CONTINUAR: ");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }

    public static void iniciarOrdem(long idTecnico, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarTecnicoRequest = new FuncionarioPorIdRequest(idTecnico);
        TecnicoPorIdResponse responseTecnico = Main.tecnicoController.buscarPorId(buscarTecnicoRequest);

        // Pedido e resposta para listar ordens de servico
        ListarOsRequest listarOsRequest = new ListarOsRequest(idTecnico, responseTecnico.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOsResponse listarOsResponse = Main.osController.listarOsTecnicoAbertas(nivelAcesso, listarOsRequest);

        if(!listarOsResponse.status()) {
            Ferramentas.mensagemErro(listarOsResponse.mensagem());
            return;
        }

        if(listarOsResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ ORDENS DE SERVIÇO ABERTAS NO MOMENTO");
            return;
        }

        // Menu
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                INICIAR ORDEM DE SERIVÇO                ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  ID OS: %-47s┃%n", os.idOs());
            System.out.printf("┃  Descrição: %-43s┃%n", os.descricao().getDescricao());
            System.out.printf("┃  Tipo da OS: %-42s┃%n", os.tipoOs().name());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       MÁQUINA                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ ID: %-47s┃ ┃%n", os.idMaquina());
            System.out.printf("┃ ┃ Nome: %-45s┃ ┃%n", os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  Tipo da OS: %-42s┃%n", os.tipoOs());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("                                                          "); // pula linha
        }

        boolean setId = false;

        while(!setId) {
            System.out.print("┃ ➤ Digite o ID: ");
            try {
                long idOs = Ferramentas.lInteiro();
                boolean check = false;

                for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
                    if(os.idOs() == idOs) {
                        check = true;
                    }
                }

                if(!check) {
                    throw new IdOsNaoEncontradoException();
                }

                AtualizarOsRequest atualizarRequest = new AtualizarOsRequest(idOs, null, null, StatusOS.EM_ANDAMENTO);
                AtualizarOsResponse atualizarResponse = Main.osController.atualizarOsTecnico(nivelAcesso, atualizarRequest);

                if(atualizarResponse.status()) {
                    Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                } else {
                    Ferramentas.mensagemErro(atualizarResponse.mensagem());
                }

                setId = true;
            } catch (InputMismatchException | IdOsNaoEncontradoException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }

        System.out.print("┃  APERTE ENTER PARA CONTINUAR: ");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }

    public static void finalizarOrdem(long idTecnico, NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();

        // Pedido e resposta para buscar supervisor
        FuncionarioPorIdRequest buscarTecnicoRequest = new FuncionarioPorIdRequest(idTecnico);
        TecnicoPorIdResponse responseTecnico = Main.tecnicoController.buscarPorId(buscarTecnicoRequest);

        // Pedido e resposta para listar ordens de servico
        ListarOsRequest listarOsRequest = new ListarOsRequest(idTecnico, responseTecnico.listaDepartamentos().getListaDepartamentos().getFirst());
        ListarOsResponse listarOsResponse = Main.osController.listarOsTecnicoAndamento(nivelAcesso, listarOsRequest);

        if(!listarOsResponse.status()) {
            Ferramentas.mensagemErro(listarOsResponse.mensagem());
            return;
        }

        if(listarOsResponse.listaResponse().isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ ORDENS DE SERVIÇO EM ANDAMENTO NO MOMENTO");
            return;
        }

        // Menu
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃               FINALIZAR ORDEM DE SERIVÇO               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  ID OS: %-47s┃%n", os.idOs());
            System.out.printf("┃  Descrição: %-43s┃%n", os.descricao().getDescricao());
            System.out.printf("┃  Tipo da OS: %-42s┃%n", os.tipoOs().name());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       MÁQUINA                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ ID: %-47s┃ ┃%n", os.idMaquina());
            System.out.printf("┃ ┃ Nome: %-45s┃ ┃%n", os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  Tipo da OS: %-42s┃%n", os.tipoOs());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            System.out.println(); // pula linha
        }

        System.out.println(); // pula linha

        boolean setId = false;

        while(!setId) {
            System.out.print("┃ ➤ Digite o ID: ");
            try {
                long idOs = Ferramentas.lInteiro();
                boolean check = false;

                for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
                    if(os.idOs() == idOs) {
                        check = true;
                    }
                }

                if(!check) {
                    throw new IdOsNaoEncontradoException();
                }

                AtualizarOsRequest atualizarRequest = new AtualizarOsRequest(idOs, null, null, StatusOS.FECHADA);
                AtualizarOsResponse atualizarResponse = Main.osController.atualizarOsTecnico(nivelAcesso, atualizarRequest);

                if(atualizarResponse.status()) {
                    Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                } else {
                    Ferramentas.mensagemErro(atualizarResponse.mensagem());
                }

                setId = true;
            } catch (InputMismatchException | IdOsNaoEncontradoException e) {
                Ferramentas.menuDefault();
            }
        }

        System.out.print("┃  APERTE ENTER PARA CONTINUAR: ");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }
}
