package Views.Gerente;

import Models.Enumeracoes.StatusMaquina;
import Util.Ferramentas;
import Service.Validator.MaquinaValidator;

import java.util.InputMismatchException;

public class MenuAlteraMaquina {
    //SET NOME DO USUÁRIO
    public static String MenuSetNomeMaquina() {
        while(true) {
            System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o Nome: ");
            String nome = Ferramentas.lString();

            try {
                MaquinaValidator.verificaIntegridadeNome(nome);
                MaquinaValidator.verificaRegrasNome(nome);
                return nome;
            }
            catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static String MenuSetLocalizacao() {
        while(true) {
            System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite a Localização: ");
            String localizacao = Ferramentas.lString();

            try {
                MaquinaValidator.verificaIntegridadeLocalizacao(localizacao);
                MaquinaValidator.verificaRegrasLocalizacao(localizacao);
                return localizacao;
            }
            catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }

    public static StatusMaquina MenuSetStatusMaquina() {
        while(true) {
            int opcao;

            System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - FUNCIONANDO"+Ferramentas.AQUA_BLUE+"                                  ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - DEFEITO"+Ferramentas.AQUA_BLUE+"                                      ┃");
            System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - EM_MANUTENÇÃO"+Ferramentas.AQUA_BLUE+"                                ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha o Status: ");

            try {
                opcao = Ferramentas.lInteiro();

                if(opcao > 3 || opcao < 1) {
                    Ferramentas.menuDefault();
                } else {
                    StatusMaquina status = switch(opcao){
                        case 1 -> StatusMaquina.FUNCIONANDO;
                        case 2 -> StatusMaquina.DEFEITO;
                        default -> StatusMaquina.EM_MANUTENCAO;
                    };

                    MaquinaValidator.verificaIntegridadeStatus(opcao);
                    MaquinaValidator.verificaRegrasStatus(opcao);
                    return status;
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
