package Views;

import Util.Ferramentas;

public class MenuRelatorio {
    public static void menuRelatorio() {
        boolean continuar = true;

        while(!continuar){
            System.out.println("|================================|");
            System.out.println("|==========  RELATÓRIO  =========|");
            System.out.println("|================================|\n");

            try{

            }catch(IllegalArgumentException | IllegalStateException e){
                Ferramentas.menuDefault();
            }

        }
    }
}
