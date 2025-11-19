package Views.Funcionario.Administrador;

import Aplicacao.Funcionario.Gerente.Dtos.BuscarPorId.GerentePorIdResponse;
import Aplicacao.Funcionario.Gerente.Dtos.Atualizar.AtualizarGerenteRequest;
import Aplicacao.Funcionario.Nucleo.Dtos.Atualizar.AtualizarFuncionarioResponse;
import Aplicacao.Funcionario.Nucleo.Dtos.BuscarPorId.FuncionarioPorIdRequest;
import Dominio.Funcionario.Nucleo.Enumeracoes.Departamento;
import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;
import Views.Funcionario.Gerente.MenuSetGerente;
import Views.Funcionario.Nucleo.MenuSetFuncionario;
import Views.Sistema.Main;
import Views.Sistema.MenuEscolhaId;

import java.util.InputMismatchException;
import java.util.List;

public class MenuUpdateADM {

    public static void updateGerente(NivelAcesso nivelAcesso) {
        long idGerente;
        int opcaoAdm = 0;

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
                System.out.println("          ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓          ");
                System.out.println("          ┃       ATUALIZAR GERENTE        ┃          ");
                System.out.println("          ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛          ");

                System.out.print("\n\n"); // pula linhas
                System.out.println("┏━━━━━━━━━━━━━━━━━━━━┓          ┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
                System.out.println("┃  EDITAR   GERENTE  ┃          ┃            ATUAL           ┃");
                System.out.println("┃━━━━━━━━━━━━━━━━━━━━┃          ┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
                System.out.printf("┃  1 - Nome          ┃          ┃  %-26s┃%n", responseId.nome().getNome());
                System.out.printf("┃  2 - CPF           ┃          ┃  %-26s┃%n", responseId.cpf().getCpf());
                System.out.printf("┃  3 - Departamento  ┃          ┃  %-26s┃%n", responseId.listaDepartamentos().getListaDepartamentos().getFirst());
                System.out.println("║  4 - Sair do Menu  ┃          ┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
                System.out.println("╚════════════════════┛");
                System.out.println("┃ ➤ Escolha:  ");

                try {
                    opcaoAdm = Ferramentas.lInteiro();

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
        }
    }
}
