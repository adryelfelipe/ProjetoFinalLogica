package Views;

import Dominio.Maquina.Enumeracoes.StatusMaquina;
import Dominio.Maquina.ObjetosDeValor.Localizacao;
import Dominio.Maquina.ObjetosDeValor.NomeMaquina;
import ProjetoBase.MaquinaService;
import ProjetoBase.UsuarioValidator;
import Util.Ferramentas;
import ProjetoBase.MaquinaValidator;

import java.util.InputMismatchException;

public class MenuSetMaquina {

    private static final MaquinaService maquinaService = new MaquinaService();

    //SET NOME DO USUÁRIO
    public static NomeMaquina MenuSetNomeMaquina() {
        System.out.print("┃ ➤ Digite o Nome: ");
        String nome = Ferramentas.lString();
        return new NomeMaquina(nome);
    }

    public static Localizacao MenuSetLocalizacao() {
        System.out.print("┃ ➤ Digite a Localização: ");
        String localizacao = Ferramentas.lString();
        return new Localizacao(localizacao);
    }

    public static StatusMaquina MenuSetStatusMaquina() {
        while(true) {
            int opcao;

            System.out.println("┃  1 - FUNCIONANDO               ┃");
            System.out.println("┃  2 - DEFEITO                   ┃");
            System.out.println("┃  3 - EM_MANUTENÇÃO             ┃");
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

    public static long SetIdMaquina(){
        int idMaquina;

        while(true)
        {
            System.out.println("┃ ➤ Digite o ID da máquina: ");

            try {
                idMaquina = Ferramentas.lInteiro();
                UsuarioValidator.verificaIntegridadeIdUsuario(idMaquina);
                maquinaService.isIdExistenteValidator(idMaquina);
                return idMaquina;
            } catch (IllegalArgumentException e) {
                Ferramentas.mensagemErro(e.getMessage());
            } catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
