package Menus;

import ProjetoBase.Ferramentas;

public class MenuInicial
{
    private static final ProjetoBase.UsuarioService usuarioService = new ProjetoBase.UsuarioService();

    public static void Menu()
    {
        int opcao = 0;

        boolean checkopcao = false;

        do
        {
            System.out.println("|=================================|");
            System.out.println("|========  MENU INICIAL  =========|");
            System.out.println("|=================================|");
            System.out.println(" ");
            System.out.println("|  1 - Login                      |");
            System.out.println("|  2 - Sair                       |");
            System.out.println("|=================================|");
            System.out.print("|  Escolha: ");

            try
            {
                opcao = Ferramentas.lInteiro();
                checkopcao = true;

                switch(opcao)
                {
                    case 1 ->
                    {
                        Ferramentas.limpaTerminal();
                        MenuLogin.login(usuarioService);
                    }
                    case 2 ->
                    {
                        Ferramentas.limpaTerminal();
                        MenuDesligar.desligar();
                    }
                    default -> Ferramentas.menuDefault();
                }
            }
            catch (Exception e)
            {
                Ferramentas.menuDefault();
            }
        }
        while (!checkopcao);
    }
}