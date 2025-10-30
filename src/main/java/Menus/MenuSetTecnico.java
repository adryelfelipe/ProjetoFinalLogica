package Menus;

import ProjetoBase.TecnicoValidator;
import ProjetoBase.Ferramentas;

public class MenuSetTecnico {

    public static int MenuSetEspecialidade()
    {
        int idEspecialidade = 0;

        while(true)
        {
            System.out.println("====  Digite a especialidade  ====");
            System.out.println("| 1 - Técnico eletrotécnica       |");
            System.out.println("| 2 - Eletricista Fabril          |");
            System.out.println("| 3 - Soldador                    |");
            System.out.println("| 4 - Eletromecânica              |");
            System.out.println("| 5 - Pintor Industrial           |");
            System.out.println("==================================");
            System.out.print("| Escolha: ");

            try
            {
                idEspecialidade = Ferramentas.lInteiro();

                switch (idEspecialidade)
                {
                    case 1 -> {
                        return 1;
                    }
                    case 2 ->{
                        return 2;
                    }
                    case 3 ->{
                        return 3;
                    }
                    case 4 ->{
                        return 4;
                    }
                    case 5 ->{
                        return 5;
                    }
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println(" ");
            }
        }
    }
}
