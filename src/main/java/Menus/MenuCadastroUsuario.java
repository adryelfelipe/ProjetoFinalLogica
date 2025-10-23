package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.UsuarioService;
import ProjetoBase.UsuarioValidator;

public class MenuCadastroUsuario
{
    private static final UsuarioService usuarioService = new UsuarioService();
    private static final UsuarioValidator usuarioValidator = new UsuarioValidator(usuarioService);

    public static void cadastroUsuario()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("================================");
            System.out.println("|           CADASTRO           |");
            System.out.println("================================\n");

            MenuSetNome.MenuSetNome(usuarioValidator);

            MenuSetCpf.MenuSetCpf(usuarioValidator);

            MenuSetSenha.MenuSetSenha(usuarioValidator);

            System.out.println("=======   CADASTRO DE:   =======");
            System.out.println("|     1 - Técnico               |");
            System.out.println("|     2 - Supervisor            |");
            System.out.println("|     3 - Gerente               |");
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
                }
                case 2:
                {
                    Ferramentas.limpaTerminal();
                }
                case 3:
                {
                    Ferramentas.limpaTerminal();
                }
            }
        }
    }
}
