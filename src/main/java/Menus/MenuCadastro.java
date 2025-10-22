package Menus;

public class MenuCadastro
{
    public static void cadastro()
    {
        boolean continuar = true;

        while(continuar)
        {
            System.out.println("================================");
            System.out.println("|           CADASTRO           |");
            System.out.println("================================\n");

            System.out.println("|     Digite seu nome: ");
            String nomeCadastro = Ferramentas.lString();

            System.out.println("|     Digite seu CPF: ");
            String cpfCadastro = Ferramentas.lString();

            System.out.println("|     Crie uma senha: ");
            String senha = Ferramentas.lString();
            System.out.println("|     Confirme a Senha: ");
            String confirmacaoSenha = Ferramentas.lString();


        }
    }
}
