package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.TecnicoValidator;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuCadastroUsuario
{
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final UsuarioValidator usuarioValidator = new UsuarioValidator();
    private static final TecnicoValidator tecnicoValidator = new TecnicoValidator();

    public static void cadastroUsuario()
    {
        boolean continuar = true;

        System.out.println("================================");
        System.out.println("|           CADASTRO           |");
        System.out.println("================================\n\n\n");

        System.out.println("=======   CADASTRO DE:   =======");
        System.out.println("|     1 - Técnico               |");
        System.out.println("|     2 - Supervisor            |");
        System.out.println("================================");
        System.out.println("|     Escolha: ");

        int escolhaDeCadastro = 0;

        try
        {
            escolhaDeCadastro = Ferramentas.lInteiro();
        }
        catch (Exception e)
        {
            System.out.println("Erro: " + e.getMessage());
        }

        switch (escolhaDeCadastro)
        {
            case 1:
            {
                Ferramentas.limpaTerminal();
                MenuCadastroTecnico.menuCadastroTecnico();
            }
            case 2:
            {
                Ferramentas.limpaTerminal();

            }
        }
    }
}
