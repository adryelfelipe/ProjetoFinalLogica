package Views.Gerente;

import Util.Ferramentas;
import Models.Gerente;

public class MenuGerenteCadastrar
{
    public static void criarUsuarios(Gerente gerente)
    {
        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                 "+Ferramentas.ORANGE_DARK+"CADASTRAR USUÁRIOS"+Ferramentas.AQUA_BLUE+"                ┃");
        System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
        System.out.println("┃                                                   ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Cadastrar Técnico"+Ferramentas.AQUA_BLUE+"                            ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Cadastrar Supervisor"+Ferramentas.AQUA_BLUE+"                         ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Cadastrar Máquina"+Ferramentas.AQUA_BLUE+"                            ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ ➤ Escolha: ");

        try
        {
            int opcaoCriarUsuario = Ferramentas.lInteiro();

            Ferramentas.limpaTerminal();
            switch(opcaoCriarUsuario)
            {
                case 1 -> MenuCadastroGerente.menuCadastroTecnico(gerente);
                case 2 -> MenuCadastroGerente.menuCadastroSupervisor(gerente);
                case 3 -> MenuCadastroGerente.menuCadastroMaquina(gerente);
                default -> Ferramentas.menuDefault();
            }
        }
        catch(IllegalArgumentException | IllegalStateException e)
        {
            Ferramentas.menuDefault();
        }
    }
}