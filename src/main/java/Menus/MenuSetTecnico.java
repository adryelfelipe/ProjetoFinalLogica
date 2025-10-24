package Menus;

import ProjetoBase.Especialidade;
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
                        idEspecialidade = Especialidade.Técnico_eletrotécnica;
                        break;
                    }
                    case 2:
                    {
                        idEspecialidade = Especialidade.Eletricista_Fabril;
                        break;
                    }
                    case 3:
                    {
                        idEspecialidade = Especialidade.Soldador;
                        break;
                    }
                    case 4:
                    {
                        idEspecialidade = Especialidade.eletromecânica;
                        break;
                    }
                    case 5:
                    {
                        idEspecialidade = Especialidade.Pintor_Industrial;
                        break;
                    }
                }
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("");
            }
            //case5 : idEspecialidde = Especialidade.Pintor_Industrial;
        }
    }
}
