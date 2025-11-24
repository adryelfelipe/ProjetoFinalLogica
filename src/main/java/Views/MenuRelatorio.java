package Views;

import Util.Ferramentas;

public class MenuRelatorio {
    public static void menuRelatorio() {
        boolean continuar = true;

        while(!continuar){
            System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
            System.out.println("┃                     RELATÓRIOS                    ┃");
            System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

            try
            {

            }catch(IllegalArgumentException | IllegalStateException e){
                Ferramentas.menuDefault();
            }

        }
    }
}
