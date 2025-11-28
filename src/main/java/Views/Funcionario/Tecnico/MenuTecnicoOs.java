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

            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                   "+Ferramentas.ORANGE_DARK+"MENU TÉCNICO - OS"+Ferramentas.AQUA_BLUE+"                    ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Visualizar minhas Ordens"+Ferramentas.AQUA_BLUE+"                          ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Iniciar ordem de serviço"+Ferramentas.AQUA_BLUE+"                          ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Finalizar ordem de serviço"+Ferramentas.AQUA_BLUE+"                        ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Retornar"+Ferramentas.AQUA_BLUE+"                                          ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

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
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                "+Ferramentas.ORANGE_DARK+"MINHAS ORDENS DE SERVIÇO"+Ferramentas.AQUA_BLUE+"                ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse())
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID OS:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", os.idOs());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Status:"+Ferramentas.AQUA_BLUE+" %-46s┃%n", os.statusOs());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Descrição:"+Ferramentas.AQUA_BLUE+" %-43s┃%n", os.descricao().getDescricao());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃ ┃%n", os.idMaquina());
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃ ┃%n", os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Tipo da OS:"+Ferramentas.AQUA_BLUE+" %-42s┃%n", os.tipoOs());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.println("                                                          "); // pula linha
        }

        System.out.println(); // pula linha

        System.out.print("┃  APERTE "+Ferramentas.ORANGE_DARK+"ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR: ");
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
        System.out.println("┃                "+Ferramentas.ORANGE_DARK+"INICIAR ORDEM DE SERIVÇO"+Ferramentas.AQUA_BLUE+"                ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID OS:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", os.idOs());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Descrição:"+Ferramentas.AQUA_BLUE+" %-43s┃%n", os.descricao().getDescricao());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Tipo da OS:"+Ferramentas.AQUA_BLUE+" %-42s┃%n", os.tipoOs().name());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃ ┃%n", os.idMaquina());
            System.out.printf("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃ ┃%n", os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Tipo da OS:"+Ferramentas.AQUA_BLUE+" %-42s┃%n", os.tipoOs());
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

        System.out.print("┃  APERTE "+Ferramentas.ORANGE_DARK+"ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR: ");
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
        System.out.println("┃               "+Ferramentas.ORANGE_DARK+"FINALIZAR ORDEM DE SERIVÇO"+Ferramentas.AQUA_BLUE+"               ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        System.out.println(); // pula linha

        for(OrdemServicoResponse os : listarOsResponse.listaResponse()) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"ID OS:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", os.idOs());
            System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"Descrição:"+Ferramentas.AQUA_BLUE+" %-43s┃%n", os.descricao().getDescricao());
            System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"Tipo da OS:"+Ferramentas.AQUA_BLUE+" %-42s┃%n", os.tipoOs().name());
            System.out.println("┃ ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓ ┃");
            System.out.println("┃ ┃                       "+Ferramentas.ORANGE_DARK+"MÁQUINA"+Ferramentas.AQUA_BLUE+"                      ┃ ┃");
            System.out.println("┃ ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃ ┃");
            System.out.printf ("┃ ┃ "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-47s┃ ┃%n", os.idMaquina());
            System.out.printf ("┃ ┃ "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-45s┃ ┃%n", os.nomeMaquina().getNome());
            System.out.println("┃ ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛ ┃");
            System.out.printf ("┃  "+Ferramentas.ORANGE_DARK+"Tipo da OS:"+Ferramentas.AQUA_BLUE+" %-42s┃%n", os.tipoOs());
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

        System.out.print("┃  "+Ferramentas.ORANGE_DARK+"APERTE ENTER"+Ferramentas.AQUA_BLUE+" PARA CONTINUAR: ");
        Ferramentas.lString();
        Ferramentas.limpaTerminal();
    }
}
