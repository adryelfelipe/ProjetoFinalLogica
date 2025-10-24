package Menus;

import ProjetoBase.TecnicoValidator;
import ProjetoBase.UsuarioValidator;

public class MenuCadastroTecnico
{
    public static void menuCadastroTecnico(UsuarioValidator usuarioValidator, TecnicoValidator tecnicoValidator) {
        System.out.println("================================");
        System.out.println("|      CADASTRO  TÉCNICO        |");
        System.out.println("================================\n");

        String nomeCadastro = MenuSetUsuario.MenuSetNome(usuarioValidator);

        String cpfCadastro = MenuSetUsuario.MenuSetCpf(usuarioValidator);

        String senhaCadastro = MenuSetUsuario.MenuSetSenha(usuarioValidator);

        int especialidade = MenuSetTecnico.MenuSetEspecialidade(tecnicoValidator);


        //TecnicoModel tecnicoModel = new TecnicoModel();

        //usuarioService.inserirTecnico(gerente, tecnicoModel);
    }
}
