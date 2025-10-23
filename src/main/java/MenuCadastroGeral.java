public class MenuCadastroGeral
{
    public static void cadastroGeral()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("================================");
            System.out.println("|           CADASTRO           |");
            System.out.println("================================\n");

            MenuSetNome.MenuSetNome();

            MenuSetCpf.MenuSetCpf();

            MenuSetSenha.MenuSetSenha();

            System.out.println("=======   CADASTRO DE:   =======");
            System.out.println("|     1 - Técnico               |");
            System.out.println("|     2 - Supervisor            |");
            System.out.println("|     3 - Gerente               |");
            System.out.println("================================");
            System.out.println("|     Escolha: ");

            try
            {
                int escolhaDeCadastro = Ferramentas.lInteiro();

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
