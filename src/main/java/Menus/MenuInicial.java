package Menus;

import ProjetoBase.Ferramentas;

import java.util.InputMismatchException;

public class MenuInicial
{
    private static final ProjetoBase.UsuarioService usuarioService = new ProjetoBase.UsuarioService();

    public static void Menu()
    {
        int opcao;

        while(true) {
            System.out.println(" ");
            System.out.println("|=================================|");
            System.out.println("|========  MENU INICIAL  =========|");
            System.out.println("|=================================|");
            System.out.println("|  1 - Login                      |");
            System.out.println("|  2 - Sair                       |");
            System.out.print("|  Escolha: ");

            try
            {
                opcao = Ferramentas.lInteiro();

                switch(opcao) {
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
            catch (InputMismatchException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}