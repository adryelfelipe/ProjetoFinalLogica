package Views.Funcionario.Gerente;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Aplicacao.Funcionario.Supervisor.Dtos.Atualizar.AtualizarSupervisorRequest;
import Aplicacao.Funcionario.Supervisor.Dtos.BuscarPorId.SupervisorPorIdResponse;
import Aplicacao.Funcionario.Tecnico.Dtos.Atualizar.TecnicoAtualizarRequest;
import Aplicacao.Funcionario.Tecnico.Dtos.BuscarPorId.TecnicoPorIdResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Dominio.Funcionario.Tecnico.Enumeracoes.Especialidade;
import Util.Ferramentas;
import Views.Funcionario.Supervisor.MenuSetSupervisor;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;
import Views.Funcionario.Tecnico.MenuSetTecnico;
import Views.Funcionario.Nucleo.MenuSetFuncionario;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MenuUpdateGerente {
    public static void menuUpdateEscolha(NivelAcesso nivelAcesso) {
        int opUpdate;
        boolean loop;

        while(true) {
            loop = false;

            while(!loop) {
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                     "+Ferramentas.ORANGE_DARK+"MENU ATUALIZAR"+Ferramentas.AQUA_BLUE+"                     ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.println("┃                                                        ┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Alterar Técnico"+Ferramentas.AQUA_BLUE+"                                   ┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Alterar Supervisor"+Ferramentas.AQUA_BLUE+"                                ┃");
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Sair do Menu"+Ferramentas.AQUA_BLUE+"                                      ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

                try {
                    opUpdate = Ferramentas.lInteiro();
                    loop = true;

                    switch(opUpdate) {
                        case 1 -> menuUpdateTecnico(nivelAcesso);
                        case 2 -> menuUpdateSupervisor(nivelAcesso);
                        case 3 -> {
                            return;
                        }

                        default -> Ferramentas.mensagemErro("┃  ERRO! TENTE NOVAMENTE!");
                    }
                }
                catch (InputMismatchException e){
                    Ferramentas.menuDefault();
                }
            }
        }
    }

    public static void menuUpdateTecnico(NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();
        // -- Garantia de inicialização -- //
        long idTecnico;
        int opcaoGer = 0;
        List<FuncionarioResponse> listaTecnicos = new ArrayList<>();
        ListaFuncionariosResponse responseLista = Main.funcionarioController.listaFuncionariosParaGerente(nivelAcesso);

        for (FuncionarioResponse funcionario : responseLista.listaFuncionarios()) {
            if(funcionario.nivelAcesso() == NivelAcesso.TECNICO) {
                listaTecnicos.add(funcionario);
            }
        }

        if (listaTecnicos.isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUM TÉCNICO PARA ATUALIZAR");
            return;
        }

        for (FuncionarioResponse funcionario : listaTecnicos)
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-50s┃%n", funcionario.id());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-48s┃%n", funcionario.nome().getNome());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Cargo: "+Ferramentas.AQUA_BLUE+"%-47s┃%n", funcionario.nivelAcesso().name());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }

        System.out.println();

        try {
            idTecnico = MenuEscolhaId.escolhaIdUpdate();
        } catch (IllegalArgumentException e) {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        while(true) {
            FuncionarioPorIdRequest requestId = new FuncionarioPorIdRequest(idTecnico);
            TecnicoPorIdResponse responseId = Main.tecnicoController.buscarPorId(requestId);

            Ferramentas.limpaTerminal();
            if(responseId.status()) {
                System.out.println("\n                                                 \n");
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                    "+Ferramentas.ORANGE_DARK+"ATUALIZAR TECNICO"+Ferramentas.AQUA_BLUE+"                   ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                          ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃    "+Ferramentas.ORANGE_DARK+"EDITAR   TÉCNICO"+Ferramentas.AQUA_BLUE+"    ┃      ┃         "+Ferramentas.ORANGE_DARK+"ATUAL"+Ferramentas.AQUA_BLUE+"          ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━┃      ┃━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"1 - Nome"+Ferramentas.AQUA_BLUE+"              ┃      ┃  %-22s┃%n", responseId.nome().getNome());
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"2 - CPF"+Ferramentas.AQUA_BLUE+"               ┃      ┃  %-22s┃%n", responseId.cpf().getCpf());
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"3 - Departamento"+Ferramentas.AQUA_BLUE+"      ┃      ┃  %-22s┃%n", responseId.listaDepartamentos().getListaDepartamentos().getFirst());
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"4 - Especialidade"+Ferramentas.AQUA_BLUE+"     ┃      ┃  %-22s┃%n", responseId.especialidade());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"5 - Sair do Menu"+Ferramentas.AQUA_BLUE+"      ┃      ┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+"  ");

                try {
                    opcaoGer = Ferramentas.lInteiro();
                    System.out.println("\n");

                    switch(opcaoGer) {
                        case 1 -> {
                            String nome = MenuSetFuncionario.MenuSetNome();
                            TecnicoAtualizarRequest atualizarRequest = new TecnicoAtualizarRequest(responseId.id(), nome, null, null, null);
                            AtualizarFuncionarioResponse atualizarResponse = Main.tecnicoController.atualizar(nivelAcesso, atualizarRequest);

                            if(atualizarResponse.status()) {
                                Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                            } else {
                                Ferramentas.mensagemErro(atualizarResponse.mensagem());
                            }
                        }

                        case 2 -> {
                            String cpf = MenuSetFuncionario.MenuSetCpf();
                            TecnicoAtualizarRequest atualizarRequest = new TecnicoAtualizarRequest(responseId.id(), null, cpf, null, null);
                            AtualizarFuncionarioResponse atualizarResponse = Main.tecnicoController.atualizar(nivelAcesso, atualizarRequest);

                            if(atualizarResponse.status()) {
                                Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                            } else {
                                Ferramentas.mensagemErro(atualizarResponse.mensagem());
                            }
                        }

                        case 3 -> {
                            List<Departamento> departamentos = MenuSetGerente.menuSetDepartamento();

                            TecnicoAtualizarRequest atualizarRequest = new TecnicoAtualizarRequest(responseId.id(), null, null, departamentos, null);
                            AtualizarFuncionarioResponse atualizarResponse = Main.tecnicoController.atualizar(nivelAcesso, atualizarRequest);

                            if(atualizarResponse.status()) {
                                Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                            } else {
                                Ferramentas.mensagemErro(atualizarResponse.mensagem());
                            }
                        }

                        case 4 -> {
                            Especialidade especialidade = MenuSetTecnico.MenuSetEspecialidade();

                            TecnicoAtualizarRequest atualizarRequest = new TecnicoAtualizarRequest(responseId.id(), null, null, null, especialidade);
                            AtualizarFuncionarioResponse atualizarResponse = Main.tecnicoController.atualizar(nivelAcesso, atualizarRequest);

                            if(atualizarResponse.status()) {
                                Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                            } else {
                                Ferramentas.mensagemErro(atualizarResponse.mensagem());
                            }
                        }

                        case 5 -> {
                            Ferramentas.limpaTerminal();
                            return;
                        }

                        default -> Ferramentas.menuDefault();
                    }
                } catch (InputMismatchException e) {
                    Ferramentas.menuDefault();
                }
            } else {
                Ferramentas.mensagemErro(responseId.mensagem());
                return;
            }

            Ferramentas.limpaTerminal();
        }
    }

    public static void menuUpdateSupervisor(NivelAcesso nivelAcesso) {
        Ferramentas.limpaTerminal();
        // -- Garantia de inicialização -- //
        long idSupervisor;
        int opcaoGer = 0;
        List<FuncionarioResponse> listaSupervisor = new ArrayList<>();
        ListaFuncionariosResponse responseLista = Main.funcionarioController.listaFuncionariosParaGerente(nivelAcesso);

        for (FuncionarioResponse funcionario : responseLista.listaFuncionarios()) {
            if(funcionario.nivelAcesso() == NivelAcesso.SUPERVISOR) {
                listaSupervisor.add(funcionario);
            }
        }

        if (listaSupervisor.isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUM SUPERVISOR PARA ATUALIZAR");
            return;
        }

        for (FuncionarioResponse funcionario : listaSupervisor)
        {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID:"+Ferramentas.AQUA_BLUE+" %-50s┃%n", funcionario.id());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Nome:"+Ferramentas.AQUA_BLUE+" %-48s┃%n", funcionario.nome().getNome());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Cargo:"+Ferramentas.AQUA_BLUE+" %-47s┃%n", funcionario.nivelAcesso().name());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        }

        try
        {
            idSupervisor = MenuEscolhaId.escolhaIdUpdate();
        } catch (IllegalArgumentException e)
        {
            Ferramentas.mensagemErro(e.getMessage());
            return;
        }

        Ferramentas.limpaTerminal();
        while(true) {
            FuncionarioPorIdRequest requestId = new FuncionarioPorIdRequest(idSupervisor);
            SupervisorPorIdResponse responseId = Main.supervisorController.buscarPorId(requestId);

            if(responseId.status()) {
                System.out.println("\n                                                       \n");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                  "+Ferramentas.ORANGE_DARK+"ATUALIZAR SUPERVISOR"+Ferramentas.AQUA_BLUE+"                  ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("                                                          ");
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃   "+Ferramentas.ORANGE_DARK+"EDITAR  SUPERVISOR"+Ferramentas.AQUA_BLUE+"   ┃      ┃          "+Ferramentas.ORANGE_DARK+"ATUAL"+Ferramentas.AQUA_BLUE+"         ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━┃      ┃━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"1 - Nome"+Ferramentas.AQUA_BLUE+"              ┃      ┃  %-22s┃%n", responseId.nome().getNome());
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"2 - CPF"+Ferramentas.AQUA_BLUE+"               ┃      ┃  %-22s┃%n", responseId.cpf().getCpf());
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"3 - Meta Mensal"+Ferramentas.AQUA_BLUE+"       ┃      ┃  %-22s┃%n", responseId.metaMensal().getValorMetaMensal());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Sair do Menu"+Ferramentas.AQUA_BLUE+"      ┃      ┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+"  ");
                try {
                    opcaoGer = Ferramentas.lInteiro();
                    System.out.println("\n");
                } catch (InputMismatchException e) {
                    Ferramentas.menuDefault();
                }

                switch(opcaoGer) {
                    case 1 -> {
                        String nome = MenuSetFuncionario.MenuSetNome();
                        AtualizarSupervisorRequest atualizarRequest = new AtualizarSupervisorRequest(responseId.id(), nome, null, null, null);
                        AtualizarFuncionarioResponse atualizarResponse = Main.supervisorController.atualizar(nivelAcesso, atualizarRequest);

                        if(atualizarResponse.status()) {
                            Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                        } else {
                            Ferramentas.mensagemErro(atualizarResponse.mensagem());
                        }
                    }

                    case 2 -> {
                        String cpf = MenuSetFuncionario.MenuSetCpf();
                        AtualizarSupervisorRequest atualizarRequest = new AtualizarSupervisorRequest(responseId.id(), null, cpf, null, null);
                        AtualizarFuncionarioResponse atualizarResponse = Main.supervisorController.atualizar(nivelAcesso, atualizarRequest);

                        if(atualizarResponse.status()) {
                            Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                        } else {
                            Ferramentas.mensagemErro(atualizarResponse.mensagem());
                        }

                    }

                    case 3 -> {
                        double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
                        AtualizarSupervisorRequest atualizarRequest = new AtualizarSupervisorRequest(responseId.id(), null, null, null, metaMensal);
                        AtualizarFuncionarioResponse atualizarResponse = Main.supervisorController.atualizar(nivelAcesso, atualizarRequest);

                        if(atualizarResponse.status()) {
                            Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                        } else {
                            Ferramentas.mensagemErro(atualizarResponse.mensagem());
                        }
                    }

                    case 4 -> {
                        Ferramentas.limpaTerminal();
                        return;
                    }

                    default -> Ferramentas.menuDefault();
                }
            } else {
                Ferramentas.mensagemErro(responseId.mensagem());
                return;
            }

            Ferramentas.limpaTerminal();
        }
    }
}
