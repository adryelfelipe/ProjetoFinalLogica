package Views.Nucleo;

import Models.*;
import Util.Ferramentas;
import Service.UsuarioService;
import Service.Validator.UsuarioValidator;
import Views.Administrador.MenuAdministrador;
import Views.Gerente.MenuGerente;
import Views.Supervisor.MenuSupervisor;
import Views.Tecnico.MenuTecnico;

public class MenuLogin
{
    public static void login(UsuarioService usuarioService) {
        // Inicialização das variáveis
        boolean verifica = false;
        String cpfLogin = "";
        String senhaLogin = "1";
        Funcionario funcionario = null;

        // Menu interativo
        while(!verifica) {
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                       LOGIN                       ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃  Digite seu CPF: ");

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
                System.out.print("┃  Digite sua senha: ");
                senhaLogin = Ferramentas.lString();
                UsuarioValidator.verificaIntegridadeSenha(senhaLogin);
                UsuarioValidator.verificarRegrasSenha(senhaLogin);
                verifica = true;
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.mensagemErro(e.getMessage());
            }
        }

        try {
            funcionario = usuarioService.loginUsuario(cpfLogin, senhaLogin);
        } catch (IllegalStateException e) {
            Ferramentas.mensagemErro("┃  ERRO! CPF OU SENHA INVÁLIDOS");
            return;
        }

        Ferramentas.limpaTerminal();
        if(funcionario instanceof Administrador){
            MenuAdministrador.menuInicial((Administrador) funcionario);
        } else if(funcionario instanceof Gerente) {
            MenuGerente.menuInicial((Gerente) funcionario);
        } else if(funcionario instanceof Supervisor) {
            MenuSupervisor.menuSupervisor((Supervisor) funcionario);
        } else if(funcionario instanceof Tecnico) {
            MenuTecnico.menuTecnico((Tecnico) funcionario);
        }
        else {
            Ferramentas.mensagemErro("┃  ERRO! CPF OU SENHA INVÁLIDOS");
        }
    }
}