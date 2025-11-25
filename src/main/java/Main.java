import Util.Ferramentas;
import Views.Nucleo.MenuInicial;

import java.sql.SQLException;
import java.sql.SQLOutput;

public class Main
{
    public static void main(String[] args) throws SQLException {
        System.out.println(Ferramentas.OCEAN_BLUE +"         █████████████████████████████████████");
        System.out.println("         ███  ");
        System.out.println("         ███   ███   ███   ███████   █████████");
        System.out.println("         ███   ███   ███   ███       ███   ███");
        System.out.println("         ███   ███   ███   ███████   ███   ███");
        System.out.println("         ███   ███   ███   ███       ███   ███");
        System.out.println("         ███████████████   ███████   █████████");
        System.out.println("                                           ███");
        System.out.println("         █████████████████████████████████████"+Ferramentas.RESET);



        MenuInicial.Menu();
    }
}