package Menus;

import ProjetoBase.TecnicoValidator;
import ProjetoBase.UsuarioValidator;

public class MenuCadastroTecnico
{
    private static final UsuarioValidator usuarioValidator = new UsuarioValidator();
    private static final TecnicoValidator tecnicoValidator = new TecnicoValidator();

    public static void menuCadastroTecnico() {
        System.out.println("================================");
        System.out.println("|      CADASTRO  TÉCNICO        |");
        System.out.println("================================\n");

        String nomeCadastro = MenuSetUsuario.MenuSetNome();

        String cpfCadastro = MenuSetUsuario.MenuSetCpf();

        String senhaCadastro = MenuSetUsuario.MenuSetSenha();

        int especialidade = MenuSetTecnico.MenuSetEspecialidade();


        //TecnicoModel tecnicoModel = new TecnicoModel();

        //usuarioService.inserirTecnico(gerente, tecnicoModel);
    }
}
