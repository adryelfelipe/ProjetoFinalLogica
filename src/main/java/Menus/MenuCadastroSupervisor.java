package Menus;

import ProjetoBase.SupervisorValidator;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuCadastroSupervisor
{
    public static void menuCadastroSupervisor()
    {
        System.out.println("================================");
        System.out.println("|       CADASTRO GERENTE       |");
        System.out.println("================================\n");

        System.out.println();

        String nomeCadastro = MenuSetUsuario.MenuSetNome();

        String cpfCadastro = MenuSetUsuario.MenuSetCpf();

        String senhaCadastro = MenuSetUsuario.MenuSetSenha();

        double metaMensal = MenuSetSupervisor.MenuSetMetaMensal();
    }
}
