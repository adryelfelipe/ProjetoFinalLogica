package Views;

import Models.joias.Departamento;
import Models.joias.StatusOS;
import ProjetoBase.*;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuSetOrdemDeServico {
    private static final UsuarioService usuarioService = new UsuarioService();

    public static StatusOS menuSetStatusOS()
    {
        int opcao;

        while(true)
        {
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.println("┃     ESCOLHA O STATUS DA OS     ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃  1 - Em Andamento              ┃");
            System.out.println("┃  2 - Atrasada                  ┃");
            System.out.println("┃  3 - Fechada                   ┃");
            System.out.println("|━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━|");
            System.out.print("┃  Escolha: ");

            try
            {
                opcao = Ferramentas.lInteiro();
                if(opcao > 3 || opcao < 1)
                {
                    Ferramentas.menuDefault();
                } else
                {
                    StatusOS statusOS = switch (opcao)
                    {
                        case 1 -> StatusOS.EM_ANDAMENTO;
                        case 2 -> StatusOS.ATRASADA;
                        default -> StatusOS.FECHADA;
                    };

                    OrdemDeServicoValidator.verificaRegrasStatus(statusOS.getId());
                    OrdemDeServicoValidator.verificaIntegridadeStatus(statusOS);
                    return statusOS;
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static long SetIdTecnico(){
        int idTecnico;

        while(true)
        {
            System.out.println("|  Digite o ID do técnico: ");

            try {
                idTecnico = Ferramentas.lInteiro();
                UsuarioValidator.verificaIntegridadeIdUsuario(idTecnico);
                usuarioService.isIdExistenteValidator(idTecnico);
                return idTecnico;
            } catch (IllegalArgumentException e) {
                Ferramentas.mensagemErro(e.getMessage());
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }

    public static String SetDescricao() {
        while(true) {
            System.out.print("|  Digite a descrição da OS: ");
            String descricao = Ferramentas.lString();

            try {
                OrdemDeServicoValidator.verificaIntegridadeDescricao(descricao);
                MaquinaValidator.verificaRegrasNome(descricao);
                return descricao;
            }
            catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static double SetValorOS() {
        while(true) {
            System.out.print("|  Digite o valor da OS: R$");

            try {
                double valorOS = Ferramentas.lDouble();
                SupervisorValidator.verificaIntegridadeMetaMensal(valorOS);
                SupervisorValidator.verificaRegrasMetaMensal(valorOS);
                return valorOS;
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
