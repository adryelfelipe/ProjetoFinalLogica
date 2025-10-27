package Menus;

import ProjetoBase.TecnicoValidator;
import ProjetoBase.Ferramentas;

public class MenuSetTecnico {

    public static int MenuSetEspecialidade(TecnicoValidator tecnicoValidator)
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
                    case 1:
                    {
                        idEspecialidade = 1;
                        break;
                    }
                    case 2:
                    {
                        idEspecialidade = 2;
                        break;
                    }
                    case 3:
                    {
                        idEspecialidade = 3;
                        break;
                    }
                    case 4:
                    {
                        idEspecialidade = 4;
                        break;
                    }
                    case 5:
                    {
                        idEspecialidade = 5;
                        break;
                    }
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("");
            }
        }
    }
}
