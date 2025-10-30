package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.GerenteModel;

public class MenuGerente
{
    public static void menuInicial(GerenteModel gerenteModel)
    {
        System.out.println("|=================================|");
        System.out.println("|=========  MENU GERENTE  ========|");
        System.out.println("|=================================|");
        System.out.println("  ");
        System.out.println("|  1 - Cadastro Usuários          |");
        System.out.println("|  2 - Visualizar Relatórios      |");
        System.out.println("|=================================|");
        System.out.print("|  Escolha: ");

        try
        {
            int opcaoGerente = Ferramentas.lInteiro();

            switch(opcaoGerente)
            {
                case 1 -> MenuGerenteCriarUsuario.criarUsuarios(gerenteModel);
                case 2 -> MenuGerenteVisualizarRelatorios.visualizarRelatorios();
                default -> Ferramentas.menuDefault();
            }
        }
        catch(IllegalArgumentException | IllegalStateException e)
        {
            Ferramentas.menuDefault();
        }
    }
}
