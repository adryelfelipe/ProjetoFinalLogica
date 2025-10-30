package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.GerenteModel;

public class MenuGerente
{
    public static void menuInicial(GerenteModel gerenteModel)
    {
        boolean continuar = false;

        while(!continuar) {
            System.out.println("|=================================|");
            System.out.println("|=========  MENU GERENTE  ========|");
            System.out.println("|=================================|");
            System.out.println("  ");
            System.out.println("|  1 - Cadastro Usuários          |");
            System.out.println("|  2 - Visualizar Relatórios      |");
            System.out.println("|  3 - Retornar                   |");
            System.out.println("|=================================|");
            System.out.print("|  Escolha: ");

            try {
                int opcaoGerente = Ferramentas.lInteiro();

                switch (opcaoGerente) {
                    case 1 -> MenuGerenteCriarUsuario.criarUsuarios(gerenteModel);
                    case 2 -> MenuGerenteVisualizarRelatorios.visualizarRelatorios();
                    case 3 ->
                    {
                        System.out.println("|  RETORNANDO AO MENU INICIAL ...");
                        MenuInicial.Menu();
                    }
                    default -> Ferramentas.menuDefault();
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                Ferramentas.menuDefault();
            }
        }
    }
}
