package Menus;

import ProjetoBase.*;

public class MenuLogin
{
    public static void login(UsuarioService usuarioService) {
        boolean verifica = false;

        String cpfLogin = "";
        String senhaLogin = "1";

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

        UsuarioModel usuario = usuarioService.loginUsuario(cpfLogin, senhaLogin);

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