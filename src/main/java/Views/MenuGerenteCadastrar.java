package Views;

import Util.Ferramentas;
import Models.GerenteModel;

public class MenuGerenteCadastrar
{
    public static void criarUsuarios(GerenteModel gerenteModel)
    {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("|==================================|");
        System.out.println("|  1 - Cadastrar Técnico           |");
        System.out.println("|  2 - Cadastrar Supervisor        |");
        System.out.println("|  3 - Cadastrar Máquina           |");
        System.out.print("  Escolha: ");

        try
        {
            int opcaoCriarUsuario = Ferramentas.lInteiro();

            Ferramentas.limpaTerminal();
            switch(opcaoCriarUsuario)
            {
                case 1 -> MenuCadastroGerente.menuCadastroTecnico(gerenteModel);
                case 2 -> MenuCadastroGerente.menuCadastroSupervisor(gerenteModel);
                case 3 -> MenuCadastroGerente.menuCadastroMaquina(gerenteModel);
                default -> Ferramentas.menuDefault();
            }
        }
        catch(IllegalArgumentException | IllegalStateException e)
        {
            Ferramentas.menuDefault();
        }
    }
}