package Menus;

import ProjetoBase.*;

public class MenuCadastroUsuario
{
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final UsuarioValidator usuarioValidator = new UsuarioValidator();
    private static final TecnicoValidator tecnicoValidator = new TecnicoValidator();

    public static void cadastroUsuario(GerenteModel gerente)
    {
        boolean continuar = true;

        System.out.println("================================");
        System.out.println("|           CADASTRO           |");
        System.out.println("================================\n\n\n");

        System.out.println("=======   CADASTRO DE:   =======");
        System.out.println("|     1 - Técnico               |");
        System.out.println("|     2 - Supervisor            |");
        System.out.println("================================");
        System.out.print("|     Escolha: ");

        int escolhaDeCadastro = 0;

        try
        {
            escolhaDeCadastro = Ferramentas.lInteiro();

            switch(escolhaDeCadastro)
            {
                case 1 ->
                {
                    Ferramentas.limpaTerminal();
                    MenuCadastroTecnico.menuCadastroTecnico(gerente);
                }
                case 2 ->
                {
                    Ferramentas.limpaTerminal();
                    MenuCadastroSupervisor.menuCadastroSupervisor(gerente);
                }
                default -> Ferramentas.menuDefault();
            }
        }
        catch (Exception e)
        {
            Ferramentas.menuDefault();
        }
    }
}
