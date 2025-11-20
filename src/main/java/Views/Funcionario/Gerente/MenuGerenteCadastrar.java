package Views.Funcionario.Gerente;

import Dominio.Funcionario.Nucleo.Enumeracoes.NivelAcesso;
import Util.Ferramentas;

import java.util.InputMismatchException;

public class MenuGerenteCadastrar {
    public static void criarUsuarios(NivelAcesso nivelAcesso) {
        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃        CADASTRAR USUARIOS      ┃");
        System.out.println("┃━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┃");
        System.out.println("┃                                ┃");
        System.out.println("┃  1 - Cadastrar Técnico         ┃");
        System.out.println("┃  2 - Cadastrar Supervisor      ┃");
        System.out.println("┃  3 - Cadastrar Máquina         ┃");
        System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
        System.out.print("┃ ➤ Escolha: ");

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