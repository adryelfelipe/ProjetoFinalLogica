package Views;

import Dominio.Entidades.*;
import Util.Ferramentas;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuLogin
{
    public static void login(UsuarioService usuarioService) {
        // Inicialização das variáveis
        boolean verifica = false;
        String cpfLogin = "";
        String senhaLogin = "1";
        Usuario usuario = null;

        // Menu interativo
        while(!verifica) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃             LOGIN              ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Digite seu CPF: ");

            try {
                cpfLogin = Ferramentas.lString();
                UsuarioValidator.verificaIntegridadeCpf(cpfLogin);
                UsuarioValidator.verificarRegrasCpf(cpfLogin);
                verifica = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }

        // RESETA A VARIÁVEL
        verifica = false;

        while (!verifica) {
            try {
                System.out.print("┃ ➤ Digite sua senha: ");
                senhaLogin = Ferramentas.lString();
                UsuarioValidator.verificaIntegridadeSenha(senhaLogin);
                UsuarioValidator.verificarRegrasSenha(senhaLogin);
                verifica = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }

        try {
            usuario = usuarioService.loginUsuario(cpfLogin, senhaLogin);
        } catch (IllegalStateException e) {
            Ferramentas.mensagemErro("ERRO! CPF OU SENHA INVÁLIDOS");
            return;
        }

        Ferramentas.limpaTerminal();
        if(usuario instanceof Administrador){
            MenuAdministrador.menuInicial((Administrador) usuario);
        } else if(usuario instanceof Gerente) {
            MenuGerente.menuInicial((Gerente) usuario);
        } else if(usuario instanceof Supervisor) {
            MenuSupervisor.menuSupervisor((Supervisor) usuario);
        } else if(usuario instanceof Tecnico) {
            MenuTecnico.menuTecnico((Tecnico) usuario);
        }
        else {
            Ferramentas.mensagemErro("ERRO! CPF OU SENHA INVÁLIDOS");
        }
    }
}