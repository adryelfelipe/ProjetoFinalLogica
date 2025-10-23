public class MenuCadastroTecnico
{
    public static void menuCadastroTecnico(UsuarioValidator usuarioValidator) {
        System.out.println("================================");
        System.out.println("|      CADASTRO  TÉCNICO        |");
        System.out.println("================================\n");

        String nome = MenuSetUsuario.MenuSetNome(usuarioValidator);
        String especialidade = MenuSetFuncionario.MenuSetEspecialidade();


        TecnicoModel tecnicoModel = new TecnicoModel();

        usuarioService.inserirTecnico(gerente, tecnicoModel)
    }
}
