package Menus;

import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuCadastroGerente {
    public static void menuCadastroGerente(UsuarioService usuarioService, UsuarioValidator usuarioValidator) {


        System.out.println("================================");
        System.out.println("|       CADASTRO GERENTE       |");
        System.out.println("================================\n");

        System.out.println();

        // ----- Atribuição de caracteríscticas de um Usuário ----- //
        //String nome = MenuSetUsuario.MenuSetNome(usuarioValidator);
        //String cpf = MenuSetUsuario.MenuSetCpf(usuarioService, usuarioValidator);
        //String senha = MenuSetUsuario.MenuSetSenha(usuarioValidator);

        // ----- Atribuição de caracteríscticas de um Gerente ----- //
        int idDepartamento = MenuSetGerente.menuSetDepartamento();

        // -- Criação do objeto e inserção no banco de dados -- //
    }
}
