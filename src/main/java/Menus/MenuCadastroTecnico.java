package Menus;

import ProjetoBase.*;

public class MenuCadastroTecnico
{
    public static void menuCadastroTecnico(UsuarioModel usuario, TecnicoService tecnicoService, TecnicoValidator tecnicoValidator, UsuarioValidator usuarioValidator, UsuarioService usuarioService) {
        System.out.println("================================");
        System.out.println("|      CADASTRO  TÉCNICO        |");
        System.out.println("================================\n");

        String nome = MenuSetUsuario.MenuSetNome(usuarioValidator);
        String cpf = MenuSetUsuario.MenuSetCpf(usuarioService, usuarioValidator);
        MenuSetUsuario.MenuSetSenha(usuarioValidator);
        int especialidade = MenuSetTecnico.MenuSetEspecialidade(tecnicoValidator);


        TecnicoModel tecnicoModel = new TecnicoModel();
        tecnicoService.inserirTecnico(gerente, tecnicoModel);
    }
}
