package Menus;

import ProjetoBase.Ferramentas;

public class MenuInicial
{
    public static void Menu()
    {
        int opcao = 0;

        boolean continuar = true;
        boolean checkopcao;

        while(continuar)
        {
            do
            {
                System.out.println(" ========  MENU INICIAL  =========");
                System.out.println("|     1 - Login                  |");
                System.out.println("|     2 - Sair                   |");
                System.out.println(" ================================");
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

            }
            while (!checkopcao);

            switch(opcao)
            {
                case 1:
                {
                    Ferramentas.limpaTerminal();
                    MenuLogin.login();

                    break;
                }
                case 2:
                {
                    Ferramentas.limpaTerminal();
                    MenuDesligar.desligar();

                    break;
                }
            }
        }
    }
}
