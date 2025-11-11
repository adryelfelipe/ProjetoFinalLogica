package Views;

import Aplicacao.Funcionario.Gerente.GerenteController;
import Util.Ferramentas;
import ProjetoBase.UsuarioService;

import java.util.InputMismatchException;

public class MenuInicial
{
    // -- Atributos -- //
    private GerenteController gerenteController;
    private MenuLogin menuLogin = new MenuLogin(gerenteController);

    // -- Construtor -- //
    public MenuInicial(GerenteController gerenteController) {
        this.gerenteController = gerenteController;
    }

    // -- Métodos -- //
    public void Menu()
    {
        int opcao;

        while(true) {
            System.out.println(" ");
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃          MENU INICIAL          ┃");
            System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
            System.out.println("┃                                ┃");
            System.out.println("┃  1 - Login                     ┃");
            System.out.println("┃  2 - Sair                      ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
            System.out.print("┃ ➤ Escolha: ");

            try
            {
                opcao = Ferramentas.lInteiro();

                switch(opcao) {
                    case 1 ->
                    {
                        Ferramentas.limpaTerminal();
                        menuLogin.login();
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