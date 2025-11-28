package Views.Funcionario.Administrador;

import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Gerente.Dtos.Atualizar.AtualizarGerenteRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.ListarFuncionarios.ListaFuncionariosResponse;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Funcionario.Gerente.MenuSetGerente;
import Views.Funcionario.Nucleo.MenuSetFuncionario;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class MenuUpdateADM {

    public static void updateGerente(NivelAcesso nivelAcesso) {
        long idGerente;
        int opcaoAdm = 0;

        List<FuncionarioResponse> listaGerente = new ArrayList<>();
        ListaFuncionariosResponse responseLista = Main.funcionarioController.listaFuncionariosParaAdm(nivelAcesso);

        for (FuncionarioResponse funcionario : responseLista.listaFuncionarios()) {
            if(funcionario.nivelAcesso() == NivelAcesso.GERENTE) {
                listaGerente.add(funcionario);
            }
        }

        if (listaGerente.isEmpty()) {
            Ferramentas.mensagemErro("┃  NÃO HÁ NENHUMA GERENTE PARA ATUALIZAR");
            return;
        }

        for (FuncionarioResponse funcionario : listaGerente)
        {

            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"ID: "+Ferramentas.AQUA_BLUE+"%-50s┃%n", funcionario.id());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Nome: "+Ferramentas.AQUA_BLUE+"%-48s┃%n", funcionario.nome().getNome());
            System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"Cargo: "+Ferramentas.AQUA_BLUE+"%-47s┃%n", funcionario.nivelAcesso().name());
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

        }

        System.out.println();

        try {
            idGerente = MenuEscolhaId.escolhaIdUpdate();
        } catch (IllegalArgumentException e) {
            Ferramentas.menuDefault();
            return;
        }

        while (true) {
            FuncionarioPorIdRequest requestId = new FuncionarioPorIdRequest(idGerente);
            GerentePorIdResponse responseId = Main.gerenteController.buscarPorId(nivelAcesso, requestId);

            if(responseId.status()) {
                System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃                   "+Ferramentas.ORANGE_DARK+"ATUALIZAR GERENTE"+Ferramentas.AQUA_BLUE+"                    ┃");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

                System.out.print("\n\n"); // pula linhas
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━┓      ┏━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃    "+Ferramentas.ORANGE_DARK+"EDITAR   GERENTE"+Ferramentas.AQUA_BLUE+"    ┃      ┃          "+Ferramentas.ORANGE_DARK+"ATUAL"+Ferramentas.AQUA_BLUE+"         ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━┃      ┃━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"1 - Nome"+Ferramentas.AQUA_BLUE+"              ┃      ┃  %-22s┃%n", responseId.nome().getNome());
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"2 - CPF"+Ferramentas.AQUA_BLUE+"               ┃      ┃  %-22s┃%n", responseId.cpf().getCpf());
                System.out.printf("┃  "+Ferramentas.ORANGE_DARK+"3 - Departamento"+Ferramentas.AQUA_BLUE+"      ┃      ┃  %-22s┃%n", responseId.listaDepartamentos().getListaDepartamentos().getFirst());
                System.out.println("┃  "+Ferramentas.ORANGE_DARK+"4 - Sair do Menu"+Ferramentas.AQUA_BLUE+"      ┃      ┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+"  ");

                try {
                    opcaoAdm = Ferramentas.lInteiro();
                    System.out.println("\n");

                    switch (opcaoAdm) {
                        case 1 -> {
                            String nome = MenuSetFuncionario.MenuSetNome();
                            AtualizarGerenteRequest atualizarRequest = new AtualizarGerenteRequest(responseId.id(), nome, null, null);
                            AtualizarFuncionarioResponse atualizarResponse = Main.gerenteController.atualizar(nivelAcesso, atualizarRequest);

                            if(atualizarResponse.status()) {
                                Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                            } else {
                                Ferramentas.mensagemErro(atualizarResponse.mensagem());
                            }
                        }

                        case 2 -> {
                            String cpf = MenuSetFuncionario.MenuSetCpf();
                            AtualizarGerenteRequest atualizarRequest = new AtualizarGerenteRequest(responseId.id(), null, cpf, null);
                            AtualizarFuncionarioResponse atualizarResponse = Main.gerenteController.atualizar(nivelAcesso, atualizarRequest);

                            if(atualizarResponse.status()) {
                                Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                            } else {
                                Ferramentas.mensagemErro(atualizarResponse.mensagem());
                            }
                        }

                        case 3 -> {
                            List<Departamento> departamentos = MenuSetGerente.menuSetDepartamento();
                            AtualizarGerenteRequest atualizarRequest = new AtualizarGerenteRequest(responseId.id(), null, null, departamentos);
                            AtualizarFuncionarioResponse atualizarResponse = Main.gerenteController.atualizar(nivelAcesso, atualizarRequest);

                            if(atualizarResponse.status()) {
                                Ferramentas.mensagemSucesso(atualizarResponse.mensagem());
                            } else {
                                Ferramentas.mensagemErro(atualizarResponse.mensagem());
                            }
                        }

                        case 4 -> {
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
}
