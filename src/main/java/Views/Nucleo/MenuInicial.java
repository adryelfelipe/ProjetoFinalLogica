package Views.Nucleo;

import Util.Ferramentas;
import Service.UsuarioService;

import java.util.InputMismatchException;

public class MenuInicial
{
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void Menu()
    {
        int opcao;

        while(true) {
            System.out.println(" ");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                       INICIO                      ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                                   ┃");
            System.out.println("┃  1 - Login                                        ┃");
            System.out.println("┃  2 - Sair                                         ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃  Escolha: ");

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