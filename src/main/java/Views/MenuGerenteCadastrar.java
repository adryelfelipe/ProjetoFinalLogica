package Views;

import Util.Ferramentas;
import Dominio.Entidades.Gerente;

public class MenuGerenteCadastrar
{
    public static void criarUsuarios(Gerente gerente)
    {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃        CADASTRAR USUARIOS        ┃");
        System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
        System.out.println("┃                                  ┃");
        System.out.println("┃  1 - Cadastrar Técnico           ┃");
        System.out.println("┃  2 - Cadastrar Supervisor        ┃");
        System.out.println("┃  3 - Cadastrar Máquina           ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
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