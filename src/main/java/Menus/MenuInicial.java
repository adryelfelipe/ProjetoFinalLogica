package Menus;

public class MenuInicial
{
    public static void main(String[] args)
    {
        int opcao = 0;

        boolean continuar = true;
        boolean checkopcao;

        while(continuar)
        {
            do {
                System.out.println("========  MENU INICIAL  ========");
                System.out.println("|     1 - Cadastro             |");
                System.out.println("|     2 - Login                |");
                System.out.println("|     3 - Sair                 |");
                System.out.println("================================");
                System.out.print("|     Escolha: ");

                try
                {
                    opcao = Ferramentas.lInteiro();
                    checkopcao = true;

                }
                catch (Exception e)
                {
                    System.out.println("Erro: " + e.getMessage());
                    checkopcao = false;
                }

            } while (!checkopcao);

            switch(opcao)
            {
                case 1:
                {

                }
                case 2 ->
                case 3 ->
            }
        }
    }
}
