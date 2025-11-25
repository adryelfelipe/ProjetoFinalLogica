package Views.Supervisor;

import Service.*;
import Service.Validator.MaquinaValidator;
import Service.Validator.OrdemDeServicoValidator;
import Service.Validator.SupervisorValidator;
import Service.Validator.UsuarioValidator;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuAlteraOrdemDeServico {
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final MaquinaService maquinaService = new MaquinaService();

    public static long SetIdTecnico(){
        int idTecnico;

        while(true)
        {
            System.out.println(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o ID do técnico: "+Ferramentas.AQUA_BLUE);

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

    public static long SetIdMaquina(){
        int idMaquina;

        while(true)
        {
            System.out.println(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o ID da máquina: "+Ferramentas.AQUA_BLUE);

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

    public static String SetDescricao() {
        while(true) {
            System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite a descrição da OS: "+Ferramentas.AQUA_BLUE);
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
            System.out.print(Ferramentas.AQUA_BLUE+"┃ ➤ Digite o valor da OS: R$"+Ferramentas.AQUA_BLUE);

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
