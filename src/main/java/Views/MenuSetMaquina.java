package Views;

import Util.Ferramentas;
import ProjetoBase.MaquinaValidator;

import java.util.InputMismatchException;

public class MenuSetMaquina {
    //SET NOME DO USUÁRIO
    public static String MenuSetNomeMaquina() {
        while(true) {
            System.out.print("|  Digite o Nome: ");
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
            System.out.print("|  Digite a Localização: ");
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

    public static int MenuSetStatusMaquina() {
        while(true) {
            int opcao;

            System.out.println("|  1 - FUNCIONANDO               |");
            System.out.println("|  2 - DEFEITO                   |");
            System.out.println("|  3 - EM_MANUTENÇÃO             |");
            System.out.print("|  Escolha o Status: ");

            try
            {
                opcao = Ferramentas.lInteiro();
                if(opcao > 3 || opcao < 1)
                {
                    Ferramentas.menuDefault();
                } else
                {
                    MaquinaValidator.verificaIntegridadeStatus(opcao);
                    MaquinaValidator.verificaRegrasStatus(opcao);
                    return opcao;
                }
            } catch(InputMismatchException e) {
                Ferramentas.menuDefault();
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }
    }
}
