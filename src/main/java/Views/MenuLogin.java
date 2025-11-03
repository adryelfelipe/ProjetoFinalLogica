package Views;

import Models.*;
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
        UsuarioModel usuario = null;

        // Menu interativo
        while(!verifica) {
            System.out.println("|================================|");
            System.out.println("|             LOGIN              |");
            System.out.println("|================================|");
            System.out.print("|   Digite seu CPF: ");

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
                System.out.print("|   Digite sua senha: ");
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
        if(usuario instanceof AdminModel){
            MenuAdministrador.menuInicial((AdminModel) usuario);
        } else if(usuario instanceof GerenteModel) {
            MenuGerente.menuInicial((GerenteModel) usuario);
        } else if(usuario instanceof SupervisorModel) {
            MenuSupervisor.menuSupervisor((SupervisorModel) usuario);
        } else if(usuario instanceof TecnicoModel) {
            MenuTecnico.menuTecnico((TecnicoModel) usuario);
        }
        else {
            Ferramentas.mensagemErro("ERRO! CPF OU SENHA INVÁLIDOS");
        }
    }
}