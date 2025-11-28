package Views.Funcionario.Gerente;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuGerenteCadastrar {
    public static void criarUsuarios(NivelAcesso nivelAcesso)
    {

        System.out.println(Ferramentas.AQUA_BLUE+"┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃                   "+Ferramentas.ORANGE_DARK+"CADASTRAR USUÁRIOS"+Ferramentas.AQUA_BLUE+"                   ┃");
        System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
        System.out.println("┃                                                        ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"1 - Cadastrar Técnico"+Ferramentas.AQUA_BLUE+"                                 ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"2 - Cadastrar Supervisor"+Ferramentas.AQUA_BLUE+"                              ┃");
        System.out.println("┃  "+Ferramentas.ORANGE_DARK+"3 - Cadastrar Máquina"+Ferramentas.AQUA_BLUE+"                                 ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ "+Ferramentas.ORANGE_DARK+"➤ Escolha:"+Ferramentas.AQUA_BLUE+" ");

        try {
            int opcaoCriarUsuario = Ferramentas.lInteiro();

            Ferramentas.limpaTerminal();
            switch(opcaoCriarUsuario) {
                case 1 -> MenuCadastroGerente.menuCadastroTecnico(nivelAcesso);
                case 2 -> MenuCadastroGerente.menuCadastroSupervisor(nivelAcesso);
                case 3 -> MenuCadastroGerente.menuCadastroMaquina(nivelAcesso);
                default -> Ferramentas.menuDefault();
            }
        }
        catch(InputMismatchException e) {
            Ferramentas.menuDefault();
        }

        Ferramentas.limpaTerminal();
    }
}