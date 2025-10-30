package Menus;

import ProjetoBase.Ferramentas;
import ProjetoBase.GerenteModel;

public class MenuGerenteCriarUsuario
{
    public static void criarUsuarios(GerenteModel gerenteModel)
    {
        System.out.println("|==================================|");
        System.out.println("|  1 - Cadastrar Usuário Técnico   |");
        System.out.println("|  2 - Cadastrar Usuário Supervisor|");
        System.out.println("|==================================|");
        System.out.println("|  Escolha: ");

        try
        {
            int opcaoCriarUsuario = Ferramentas.lInteiro();

            switch(opcaoCriarUsuario)
            {
                case 1 -> MenuCadastroTecnico.menuCadastroTecnico(gerenteModel);
                case 2 -> MenuCadastroSupervisor.menuCadastroSupervisor(gerenteModel);
                default -> Ferramentas.menuDefault();
            }
        }
        catch(IllegalArgumentException | IllegalStateException e)
        {
            Ferramentas.menuDefault();
        }
    }
}